class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[] dr = new int[]{-1,-1,-1,0,0,0,1,1,1};
        int[] dc = new int[]{-1,0,1,-1,0,1,-1,0,1};
        int[][] ans = new int[n-2][n-2];
        for (int r=1; r<n-1; r++) {
            for (int c=1; c<n-1; c++) {
                int max = 0;
                for (int i=0; i<9; i++) {
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    max = Math.max(max, grid[nr][nc]);
                }
                ans[r-1][c-1] = max;
            }
        }
        return ans;
    }
}