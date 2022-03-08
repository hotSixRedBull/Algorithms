class Solution {
    int[] dp = new int[101];
    public int getMaximumGenerated(int n) {
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        int max = 0;
        for (int i=0; i<=n; i++) {
            int ith = recursive(i);
            // System.out.println(i+" th : "+ith);
            max = Math.max(max, ith);
        }
        return max;
    }
    public int recursive(int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        if (n % 2 == 0) {
            dp[n] = recursive(n/2);
            return dp[n];
        }
        if (n % 2 == 1) {
            dp[n] = recursive(n/2) + recursive(n/2+1);
            return dp[n];
        }
        return 0;
    }
}