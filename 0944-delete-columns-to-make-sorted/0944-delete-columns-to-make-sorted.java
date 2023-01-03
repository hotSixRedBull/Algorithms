class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs[0].length();
        int cnt = 0;
        for (int i=0; i<n; i++) {
            char[] built = new char[strs.length];
            boolean isSorted = true;
            built[0] = strs[0].charAt(i);
            for (int j=1; j<strs.length; j++) {
                built[j] = strs[j].charAt(i);
                if (built[j] < built[j-1]) {
                    isSorted = false;
                    break;
                }
            }
            if (!isSorted) {
                cnt++;
            }
        }
        return cnt;
    }
}