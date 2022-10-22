class Solution {
    public String minWindow(String s, String t) {
        int[] tArr = new int[256];
        char offset = 'A';
        for (int i=0; i<t.length(); i++) {
            tArr[t.charAt(i)-offset]++;
        }
        
        int minLen = Integer.MAX_VALUE;
        String minStr = "";
        int left = 0;
        int right = s.length();
        if (s.equals(t)) {
            return s;
        }
        while (left < right) {
            int mid = left - (left - right - 1)/2;
            // System.out.println(String.format("mid: %d", mid));
            boolean complete = false;
            int[] sArr = new int[256];
            for (int i=0; i<mid; i++) {
                sArr[s.charAt(i)-offset]++;
            }
            if (!isComplete(sArr, tArr)) {
                for (int i=mid; i<s.length(); i++) {
                    sArr[s.charAt(i)-offset]++;
                    sArr[s.charAt(i-mid)-offset]--;
                    if (isComplete(sArr, tArr)) {
                        if (mid < minLen) {
                            minLen = mid;
                            minStr = s.substring(i-mid+1, i+1);
                        }
                        complete = true;
                        break;
                    }
                }
            }
            else if (mid < minLen) {
                complete = true;
                minLen = mid;
                minStr = s.substring(0, mid);
            }
            
            // System.out.println(String.format("complete: %s", complete));
            if (complete) {
                right = mid-1;
            }
            else {
                left = mid;
            }
        }
        return minStr;
    }
    
    public boolean isComplete(int[] sArr, int[] tArr) {
        // System.out.println(String.format("sArr: %s", Arrays.toString(sArr)));
        // System.out.println(String.format("tArr: %s", Arrays.toString(tArr)));
        for (int i=0; i<256; i++) {
            if (tArr[i] > sArr[i]) {
                // System.out.println("false");
                return false;
            }
        }
        // System.out.println("true");
        return true;
    }
}