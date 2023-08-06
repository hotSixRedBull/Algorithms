// saw solution
// coded on my own
class Solution {
    public int numMusicPlaylists(int n, int goal, int k) {
        int mod = 1_000_000_007;
        long[][] dp = new long[goal+1][n+1];
        dp[0][0] = 1;
        for (int i=0; i<=goal; i++) {
            for (int j=0; j<=n; j++) {
                if (i > 0 && j >= k) {
                    dp[i][j] += (dp[i-1][j]*(j-k)) % mod;
                    dp[i][j] %= mod;
                }
                if (i > 0 && j > 0) {
                    dp[i][j] += (dp[i-1][j-1]*(n-j+1))% mod;
                }
                dp[i][j] %= mod;
            }
        }
        return (int) dp[goal][n];
    }
}

/*
16
16
4
*/