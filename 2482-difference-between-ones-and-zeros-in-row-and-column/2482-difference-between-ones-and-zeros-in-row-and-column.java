class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ones_row = new int[m];
        int[] ones_col = new int[n];
        for (int r=0; r<m; r++) {
            int cnt = 0;
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 1) {
                    cnt++;
                }
            }
            ones_row[r] = cnt;
        }
        
        
        for (int c=0; c<n; c++) {
            int cnt = 0;
            for (int r=0; r<m; r++) {
                if (grid[r][c] == 1) {
                    cnt++;
                }
            }
            ones_col[c] = cnt;
        }
        
        int[][] result = new int[m][n];
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                result[r][c] = ones_row[r]*2 + ones_col[c]*2 - m - n;
            }
        }
        return result;
    }
}