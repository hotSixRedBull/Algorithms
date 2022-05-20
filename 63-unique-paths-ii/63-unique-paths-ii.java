class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int N = obstacleGrid.length;
        int M = obstacleGrid[0].length;
        
        int[][] dp = new int[N][M];
        if (obstacleGrid[0][0] != 1) {
            dp[0][0] = 1;
        }
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                if (obstacleGrid[r][c] != 1) {
                    if (r > 0
                       && obstacleGrid[r-1][c] != 1) {
                        dp[r][c] += dp[r-1][c];
                    }
                    if (c > 0
                       && obstacleGrid[r][c-1] != 1) {
                        dp[r][c] += dp[r][c-1];
                    }
                }
            }
        }
        return dp[N-1][M-1];
    }
}