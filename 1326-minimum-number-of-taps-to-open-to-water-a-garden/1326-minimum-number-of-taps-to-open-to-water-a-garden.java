
//saw solution
//couldn't understand the problem. especially 2nd example
class Solution {
    public int minTaps(int n, int[] ranges) {
        // Define an infinite value
        final int INF = (int) 1e9;
        
        // Create an array to store the minimum number of taps needed for each position
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        
        // Initialize the starting position of the garden
        dp[0] = 0;
        
        for (int i = 0; i <= n; i++) {
            // Calculate the leftmost position reachable by the current tap
            int tapStart = Math.max(0, i - ranges[i]);
            // Calculate the rightmost position reachable by the current tap
            int tapEnd = Math.min(n, i + ranges[i]);
            
            for (int j = tapStart; j <= tapEnd; j++) {
                // Update with the minimum number of taps
                dp[tapEnd] = Math.min(dp[tapEnd], dp[j] + 1);
            }
        }
        
        // Check if the garden can be watered completely
        if (dp[n] == INF) {
            // Garden cannot be watered
            return -1;
        }
        
        // Return the minimum number of taps needed to water the entire garden
        return dp[n];
    }
}
/*
class Solution {
    int[][] dp;
    public int minTaps(int n, int[] ranges) {
        dp = new int[n+1][n+1];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], 10001);
        }
        
        int min = Math.max(0, 0-ranges[0]);
        int max = Math.min(n, 0+ranges[0]);
        for (int g=0; g<=max; g++) {
            dp[0][g] = 1;
        }
        // System.out.println(Arrays.toString(dp[0]));
        for (int t=1; t<=n; t++) {
            min = Math.max(0, t-ranges[t]);
            max = Math.min(n, t+ranges[t]);
            for (int g=0; g<min; g++) {
                dp[t][g] = dp[t-1][g];
            }
            for (int g=min; g<=max; g++) {
                if (min == 0) {
                    dp[t][g] = Math.min(dp[t-1][g], 1);
                }
                else {
                    dp[t][g] = Math.min(dp[t-1][g], dp[t-1][min-1]+1);
                }
            }
            for (int g=max+1; g<=n; g++) {
                dp[t][g] = Math.min(dp[t][g], dp[t-1][g]);
            }
            // System.out.println(Arrays.toString(dp[t]));
        }
        
        return dp[n][n] == n+1 ? -1 : dp[n][n];
    }
}
*/