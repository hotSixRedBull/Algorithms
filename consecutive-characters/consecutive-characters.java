class Solution {
    public int maxPower(String s) {
        char saved = s.charAt(0);
        int cnt = 1;
        int max = 1;
        for (int i=1; i<s.length(); i++) {
            char cur = s.charAt(i);
            if (saved == cur) {
                cnt++;
            }
            else {
                max = Math.max(max, cnt);
                saved = cur;
                cnt = 1;
            }
        }
        max = Math.max(max, cnt);
        return max;
    }
}