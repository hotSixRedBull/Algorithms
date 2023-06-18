class Solution {
    int m;
    int n;
    int mod;
    int[][] grid;
    long[][] dp;
    int[] dr;
    int[] dc;
    public int countPaths(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        this.mod = 1_000_000_007;
        this.grid = grid;
        dp = new long[m][n];
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                dp[r][c] = -1;
            }
        }
        
        dr = new int[]{-1,0,1,0};
        dc = new int[]{0,1,0,-1};
        
        long sum = 0;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                sum += recursive(r,c);
                sum %= mod;
            }
        }
        // for (int r=0; r<m; r++) {
        //     System.out.println(Arrays.toString(dp[r]));
        // }
        return (int) sum;
    }
    public long recursive(int r, int c) {
        if (dp[r][c] != -1) {
            return dp[r][c];
        }
        long local = 1;
        for (int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0
               || nc < 0
               || nr >= m
               || nc >= n
               || grid[r][c] >= grid[nr][nc]) {
                continue;
            }
            local += recursive(nr, nc);
            local %= mod;
        }
        return dp[r][c] = local;
    }
}