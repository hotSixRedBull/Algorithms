class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i=0; i<=n; i++) {
            String s = Integer.toBinaryString(i);
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    cnt++;
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
}