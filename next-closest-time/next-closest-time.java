class Solution {
    static String answerString = "99:99"; 
    static int answerDiffWithInputVal = Integer.MAX_VALUE;
    static int inputVal;
    public String nextClosestTime(String time) {
        answerString = "99:99"; 
        answerDiffWithInputVal = Integer.MAX_VALUE;
        inputVal = convertToInteger(time);
        Set<Character> set = new HashSet();
        set.add(time.charAt(0));
        set.add(time.charAt(1));
        set.add(time.charAt(3));
        set.add(time.charAt(4));
        recursive(set, "", 0);
        if (answerString.equals("99:99")) {
            return time;
        }
        return answerString;
    }
    static int convertToInteger(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int minute = Integer.parseInt(time.substring(3,5));
        // System.out.println(String.format("%s: %d",time, hour*60+minute));
        return hour*60+minute;
    }
    static void recursive(Set<Character> candidate, String built, int pos) {
        if (pos == 5) {
            //test
            // System.out.println(built);
            int builtDiff = convertToInteger(built);
            int timeDiff = Integer.MAX_VALUE;
            if (builtDiff < inputVal) {
                //next day
                timeDiff = 1440-inputVal+builtDiff;
            }
            else if (builtDiff > inputVal) {
                //on the day
                timeDiff = builtDiff-inputVal;
            }
            if (timeDiff < answerDiffWithInputVal) {
                answerDiffWithInputVal = timeDiff;
                answerString = built;
                // System.out.println(String.format("%s, %d", answerString, timeDiff));
            }
            return;
        }
        for (char c : candidate) {
            if (pos == 1 
                && ((built.charAt(0) == '2' && (int)(c-'0') < 4) || built.charAt(0) != '2')) {
                recursive(candidate, built+c+":", 3);
            }
            else if ((pos == 0 && (int)(c-'0') < 3)
                    || (pos == 4)
                    || (pos == 3 && (int)(c-'0') < 6)) {
                recursive(candidate, built+c, pos+1);
            }
        }
    }
}