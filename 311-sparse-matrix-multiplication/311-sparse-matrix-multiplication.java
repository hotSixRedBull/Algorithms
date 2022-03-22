class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int[][] ans = new int[mat1.length][mat2[0].length];
        for (int r=0; r<mat1.length; r++) {
            for (int c=0; c<mat2[0].length; c++) {
                ans[r][c] = getVal(mat1, mat2, r, c);
            }
        }
        return ans;
    }
    
    public int getVal(int[][] mat1, int[][] mat2, int row, int col) {
        int sum = 0;
        for (int i=0; i<mat1[row].length; i++) {
            sum += mat1[row][i]*mat2[i][col];
        }
        return sum;
    }
}