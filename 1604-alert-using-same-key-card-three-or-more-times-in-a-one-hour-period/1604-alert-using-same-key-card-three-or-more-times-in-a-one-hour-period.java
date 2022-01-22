class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> timeMap = new HashMap<>();
        Set<String> ansSet = new HashSet<>();
        for (int i=0; i<keyName.length; i++) {
            List<Integer> timeList = timeMap.getOrDefault(keyName[i], new ArrayList<>());
            timeList.add(timeToInt(keyTime[i]));
            timeList.sort(new Comparator<Integer>() {
                @Override
                public int compare(Integer arg0, Integer arg1) {
                    if (arg0 > arg1) {
                        return 1;
                    }
                    else if (arg0 < arg1) {
                        return -1;
                    }
                    else if (arg0 == arg1) {
                        return 0;
                    }
                    return 0;
                }
            });
            if (timeList.size() > 2 && getAlert(timeList)) {
                ansSet.add(keyName[i]);
            }
            timeMap.put(keyName[i], timeList);
        }
        
        List<String> ansList = new ArrayList<>(ansSet);  
        ansList.sort(new Comparator<String>() {
               @Override
               public int compare(String arg0, String arg1) {
                      return arg0.compareTo(arg1);
               }
        });
        return ansList;
    }
    
    public String timeToString(int time) {
        int hour = time/60;
        int minute = time%60;
        String hourString = hour < 10 ? "0"+Integer.toString(hour) : Integer.toString(hour);
        String minuteString = minute < 10 ? "0"+Integer.toString(minute) : Integer.toString(minute);
        return hourString+":"+minuteString;
    }
    
    public int timeToInt(String time) {
        String[] split = time.split(":");
        return Integer.valueOf(split[0])*60+Integer.valueOf(split[1]);
    }
    
    public boolean getAlert(List<Integer> timeList) {
        // System.out.println(timeList);
        for (int start=0; start<timeList.size(); start++) {
            int base = timeList.get(start);
            int cnt = 1;
            for (int end=start+1; end<start+3 && end<timeList.size(); end++) {
                int compared = timeList.get(end)-base;
                if (compared <= 60 && compared >= 0) {
                    cnt++;
                }
            }
            if (cnt == 3) {
                return true;
            }
        }
        return false;
    }
}