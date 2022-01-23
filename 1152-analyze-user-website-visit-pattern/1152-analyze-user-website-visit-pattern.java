class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, List<Pair<Integer, String>>> nameMap = new HashMap<>();
        for (int i=0; i<username.length; i++) {
            List<Pair<Integer, String>> visited = nameMap.getOrDefault(username[i], new ArrayList<>());
            visited.add(new Pair(timestamp[i], website[i]));
            nameMap.put(username[i], visited);
        }
        
        // System.out.println("first process done.");
        
        //generate patterns
        HashMap<String, Integer> patternMap = new HashMap<>();
        String maxKey = "";
        int maxValue = 0;
        for (Map.Entry<String, List<Pair<Integer, String>>> entry : nameMap.entrySet()) {
            // System.out.println("Entry list: "+entry.getValue());
            if (entry.getValue().size() < 3) {
                continue;
            }
            
            String[] pattern = new String[3];
            List<Pair<Integer, String>> visited = entry.getValue();
            visited.sort(new Comparator<>() {
                @Override
                public int compare(Pair<Integer, String> arg0, Pair<Integer, String> arg1) {
                    if (arg0.getKey() < arg1.getKey()) {
                        return -1;
                    }
                    else if (arg0.getKey() > arg1.getKey()) {
                        return 1;
                    }
                    return 0;
                }
            });
            int size = visited.size();
            Set<String> patternStringSet = new HashSet<>();
            for (int i=0; i<size; i++) {
                pattern[0] = visited.get(i).getValue();
                for (int j=i+1; j<size; j++) {
                    pattern[1] = visited.get(j).getValue();
                    for (int k=j+1; k<size; k++) {
                        pattern[2] = visited.get(k).getValue();
                        patternStringSet.add(String.join(",", pattern));
                    }
                }
            }
            // System.out.println("patternStringSet: "+patternStringSet);
            
            for (String key : patternStringSet) {
                int curVal = patternMap.getOrDefault(key, 0)+1;
                patternMap.put(key, curVal);
                if (curVal > maxValue || (curVal == maxValue && maxKey.compareTo(key) > 0)) {
                    maxValue = curVal;
                    maxKey = key;
                }
            }
            // System.out.println(patternMap);
        }
        
        // System.out.println("second process done.");
        
        return Arrays.asList(maxKey.split(","));
    }
}