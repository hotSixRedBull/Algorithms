class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][][] dp = new int[m][n][m];
        int max = 0;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (matrix[r][c] == '1') {
                    for (int h=0; h<=r; h++) {
                        int height = r-h;
                        if (matrix[height][c] != '1') {
                            break;
                        }
                        if (c > 0) {
                            dp[r][c][h] = dp[r][c-1][h]+1;
                        }
                        else {
                            dp[r][c][h] = 1;
                        }
                        // System.out.println("??");
                        max = Math.max(max, dp[r][c][h]*(h+1));
                    }
                }
            }
        }
        return max;
    }
}