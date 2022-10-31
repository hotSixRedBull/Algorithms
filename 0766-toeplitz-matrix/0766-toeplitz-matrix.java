class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r=0; r<matrix.length; r++) {
            int standard = matrix[r][0];
            for (int d=1; d<matrix[r].length; d++) {
                if (r+d >= matrix.length) {
                    break;
                }
                if (matrix[r+d][d] != standard) {
                    return false;
                }
            }
        }
        for (int c=1; c<matrix[0].length; c++) {
            int standard = matrix[0][c];
            for (int d=1; d<matrix.length; d++) {
                if (d+c >= matrix[0].length) {
                    break;
                }
                if (matrix[d][d+c] != standard) {
                    return false;
                }
            }
        }
        return true;
    }
}