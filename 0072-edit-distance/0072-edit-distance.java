class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=1; i<=m; i++) {
            dp[i][0] = dp[i-1][0]+1;
        }
        for (int i=1; i<=n; i++) {
            dp[0][i] = dp[0][i-1]+1;
        }
        for (int r=1; r<=m; r++) {
            char c1 = word1.charAt(r-1);
            for (int c=1; c<=n; c++) {
                char c2 = word2.charAt(c-1);
                if (c1 == c2) {
                    dp[r][c] = dp[r-1][c-1];
                }
                else {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, dp[r-1][c-1]+1);
                    min = Math.min(min, dp[r-1][c]+1);
                    min = Math.min(min, dp[r][c-1]+1);
                    dp[r][c] = min;
                }
            }
        }
        return dp[m][n];
    }
}