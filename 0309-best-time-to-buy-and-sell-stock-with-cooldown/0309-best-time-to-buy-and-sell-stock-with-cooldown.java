class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] buy = new int[n][n];
        for (int i=0; i<n; i++) {
            int min = prices[i];
            for (int j=i; j<n; j++) {
                min = Math.min(min, prices[j]);
                buy[i][j] = min;
            }
            // System.out.println(String.format("buy[%d]: %s", i, Arrays.toString(buy[i])));
        }
        
        int[] dp = new int[n];
        int max = 0;
        for (int i=0; i<n; i++) {
            dp[i] = 0;
            if (i > 0) {
                //today is cooldown
                dp[i] = Math.max(dp[i], dp[i-1]);
                
                //sell today
                for (int pos = 0; pos <= i-1; pos++) {
                    int local = 0;
                    if (pos > 1) {
                        local += dp[pos-2];
                    }
                    local += prices[i];
                    local -= buy[pos][i-1];
                    dp[i] = Math.max(dp[i], local);
                }
            }
            
            if (i > 2) {
                //buy today
                max = Math.max(max, dp[i-2]);
                dp[i] = Math.max(dp[i], max);
            }
        }
        
        // System.out.println(String.format("dp: %s", Arrays.toString(dp)));
        return dp[n-1];
    }
}