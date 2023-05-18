class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int[][] dp = new int[n][k];
        for (int i=0; i<k; i++) {
            dp[0][i] = costs[0][i];
        }
        for (int house=1; house<n; house++) {
            for (int color=0; color<k; color++) {
                int otherColorMin = Integer.MAX_VALUE;
                for (int otherColor = 0; otherColor<k; otherColor++) {
                    if (color == otherColor) {
                        continue;
                    }
                    otherColorMin = Math.min(otherColorMin, dp[house-1][otherColor]);
                }
                dp[house][color] = otherColorMin+costs[house][color];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i=0; i<k; i++) {
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
}