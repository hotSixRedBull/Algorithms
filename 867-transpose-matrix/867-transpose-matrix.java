class Solution {
    public int[][] transpose(int[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;
        int[][] ret = new int[M][N];
        for (int c=0; c<M; c++) {
            for (int r=0; r<N; r++) {
                ret[c][r] = matrix[r][c];
            }
        }
        return ret;
    }
}