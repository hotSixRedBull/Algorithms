class Solution {
    public int minimumMoves(String s) {
        int cnt = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'X') {
                i += 2;
                cnt++;
            }
        }
        return cnt;
    }
}