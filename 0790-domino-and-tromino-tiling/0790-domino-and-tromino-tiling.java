class Solution {
    public int numTilings(int n) {
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        int offset = 2;
        for (int i=4; i<=n; i++) {
            dp[i] += dp[i-1] % 1_000_000_007;
            dp[i] %= 1_000_000_007;
            dp[i] += dp[i-2] % 1_000_000_007;
            dp[i] %= 1_000_000_007;
            for (int j=i-3; j>=1; j--) {
                dp[i] += (2*dp[j]) % 1_000_000_007;
                dp[i] %= 1_000_000_007;
            }
            dp[i] += offset;
            dp[i] %= 1_000_000_007;
        }
        return (int)(dp[n] % 1_000_000_007);
    }
}