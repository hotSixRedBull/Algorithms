class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int N = mat.length;
        int M = mat[0].length;
        int size = N*M;
        if (size != r*c) {
            return mat;
        }
        Queue<Integer> q = new ArrayDeque();
        for (int row=0; row<N; row++) {
            for (int col=0; col<M; col++) {
                q.add(mat[row][col]);
            }
        }
        
        int[][] res = new int[r][c];
        for (int row=0; row<r; row++) {
            for (int col=0; col<c; col++) {
                res[row][col] = q.poll();
            }
        }
        return res;
    }
}