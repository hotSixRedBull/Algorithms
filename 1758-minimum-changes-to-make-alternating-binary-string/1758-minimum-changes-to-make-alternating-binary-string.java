class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int caseA = 0;
        int caseB = 0;
        int cur = 0;
        for (int i=0; i<n; i++) {
            char c = s.charAt(i);
            if (cur == 0) {
                if (c == '0') {
                    caseB++;
                }
                else {
                    caseA++;
                }
            }
            else {
                if (c == '0') {
                    caseA++;
                }
                else {
                    caseB++;
                }
            }
            cur ^= 1;
        }
        return Math.min(caseA, caseB);
    }
}