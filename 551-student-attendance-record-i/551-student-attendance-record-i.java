class Solution {
    public boolean checkRecord(String s) {
        int lCnt = 0, aCnt = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'A':
                    lCnt = 0;
                    aCnt++;
                    if (aCnt > 1) {
                        return false;
                    }
                    break;
                case 'L':
                    lCnt++;
                    if (lCnt > 2) {
                        return false;
                    }
                    break;
                default:
                    lCnt = 0;
                    break;
            }
        }
        return true;
    }
}