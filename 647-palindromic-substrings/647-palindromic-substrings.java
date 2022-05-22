class Solution {
    public int countSubstrings(String s) {
        boolean[][] isPal = new boolean[s.length()][s.length()];
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            int start = i;
            int end = i;
            while (start >= 0
                  && end <s.length()
                  && s.charAt(start) == s.charAt(end)) {
                isPal[start--][end++] = true;
                cnt++;
            }
            start = i;
            end = i+1;
            while (start >= 0
                  && end <s.length()
                  && s.charAt(start) == s.charAt(end)) {
                isPal[start--][end++] = true;
                cnt++;
            }
        }
        return cnt;
    }
}