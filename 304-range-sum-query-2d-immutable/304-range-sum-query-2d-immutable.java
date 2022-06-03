class NumMatrix {
    static int[][] mat;
    static int[][] acc;
    public NumMatrix(int[][] matrix) {
        mat = matrix;
        acc = new int[matrix.length][matrix[0].length];
        acc[0][0] = matrix[0][0];
        for (int i=1; i<matrix[0].length; i++) {
            acc[0][i] = acc[0][i-1] + matrix[0][i];
        }
        for (int r=1; r<matrix.length; r++) {
            acc[r][0] = acc[r-1][0] + matrix[r][0];
            int[] lineSum = new int[matrix[0].length];
            lineSum[0] = matrix[r][0];
            for (int c=1; c<matrix[0].length; c++) {
                lineSum[c] = lineSum[c-1] + matrix[r][c];
                acc[r][c] = acc[r-1][c] + lineSum[c];
            }
        }
        for (int r=0; r<matrix.length; r++) {
            System.out.println(Arrays.toString(acc[r]));
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // System.out.println(String.format("(%d,%d), (%d,%d)", row1, col1, row2, col2));
        int upper = row1 > 0 ? acc[row1-1][col2] : 0;
        int left  = col1 > 0 ? acc[row2][col1-1] : 0;
        int leftUpper = row1 > 0 && col1 > 0 ? acc[row1-1][col1-1] : 0;
        int whole = acc[row2][col2];
        // System.out.println(String.format("upper: %d, left: %d, whole: %d, leftUpper", upper, left, whole, leftUpper));
        
        return whole-upper-left+leftUpper;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */