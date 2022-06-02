class Solution {
    int N;
    int M;
    int[][] dp;
    int[][] map;
    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};
    public int longestIncreasingPath(int[][] matrix) {
        N = matrix.length;
        M = matrix[0].length;
        dp = new int[N][M];
        map = matrix;
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                dp[r][c] = -1;
            }
        }
        int max = 0;
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                max = Math.max(max, getLongestPath(r, c));
            }
        }
        return max;
    }
    
    public int getLongestPath(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        int localMax = 0;
        for (int i=0; i<4; i++) {
            int nextR = r+dr[i];
            int nextC = c+dc[i];
            if (nextR >= 0
               && nextC >= 0
               && nextR < N
               && nextC < M
               && map[nextR][nextC] > map[r][c]) {
                localMax = Math.max(localMax, getLongestPath(nextR, nextC));
            }
        }
        dp[r][c] = 1+localMax;
        // System.out.println(String.format("%d,%d: %d", r, c, dp[r][c]));
        return dp[r][c];
    }
    
}