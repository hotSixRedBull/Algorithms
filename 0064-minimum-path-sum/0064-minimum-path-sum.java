class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int sum = 0; sum < m+n; sum++) {
            for (int r=0; r<m; r++) {
                int c = sum-r;
                if (c >= n || c < 0) {
                    continue;
                }
                int left = c > 0 ? dp[r][c-1] : -1;
                int up = r > 0? dp[r-1][c] : -1;
                int min = 0;
                if (left == -1) {
                    if (up != -1) {
                        min = up;
                    }
                }
                else {
                    if (up != -1) {
                        min = Math.min(left, up);
                    }
                    else {
                        min = left;
                    }
                }
                dp[r][c] = min + grid[r][c];
                // System.out.println(Arrays.toString(dp[r]));
            }
            // System.out.println("");
        }
        return dp[m-1][n-1];
    }
}