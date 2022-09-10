// saw solution
// wrote code on my own after understanding
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        if (k <= 0 || n <= 0) {
            return 0;
        }
        
        if (2*k > n) {
            int max = 0;
            for (int i=1; i<n; i++) {
                max += Math.max(0, prices[i]-prices[i-1]);
            }
            return max;
        }
        
        int[][][] dp = new int[n][k+1][2];
        
        for (int i=0; i<n; i++) {
            for (int j=0; j<=k; j++) {
                dp[i][j][0] = -1000000000;
                dp[i][j][1] = -1000000000;
            }
        }
        
        dp[0][0][0] = 0;
        dp[0][1][1] = -prices[0];
        
        for (int i=1; i<n; i++) {
            for (int j=0; j<=k; j++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                if (j > 0) {
                    dp[i][j][1] = Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        
        int max = 0;
        for (int i=0; i<=k; i++) {
            max = Math.max(max, dp[n-1][i][0]);
        }
        return max;
    }
}
