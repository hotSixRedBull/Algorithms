//saw solution
class Solution {
    int[][][] memo;
    int MOD = (int) 1e9 + 7;
    int n;
    int m;
    
    public int numOfArrays(int n, int m, int k) {
        memo = new int[n][m + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        
        this.n = n;
        this.m = m;
        return dp(0, 0, k);
    }
    
    public int dp(int i, int maxSoFar, int remain) {
        if (i == n) {
            if (remain == 0) {
                return 1;
            }
            
            return 0;
        }
        
        if (remain < 0) {
            return 0;
        }
        
        if (memo[i][maxSoFar][remain] != -1) {
            return memo[i][maxSoFar][remain];
        }
        
        int ans = 0;
        for (int num = 1; num <= maxSoFar; num++) {
            ans = (ans + dp(i + 1, maxSoFar, remain)) % MOD;
        }

        for (int num = maxSoFar + 1; num <= m; num++) {
            ans = (ans + dp(i + 1, num, remain - 1)) % MOD;
        }
        
        memo[i][maxSoFar][remain] = ans;
        return ans;
    }
}
/*
class Solution {
    long[][][] dp;
    long mod;
    public int numOfArrays(int n, int m, int k) {
        dp = new long[n+1][m+1][k+1];
        mod = 1_000_000_007;
        if (m == k) {
            return 1;
        }
        else if (m < k) {
            return 0;
        }
        else {
            dp[n][k][k] = 1;
            for (int i=k+1; i<=m; i++) {
                dp[n][i][k] += dp[n][i-1][k] + (i-k+1);
                dp[n][i][k] %= mod;
            }
            return (int) dp[n][m][k];
        }
    }
}
*/