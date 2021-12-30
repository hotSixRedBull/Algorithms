class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int r=0; r<mat.length; r++) {
            sum += mat[r][r];
            sum += mat[r][mat.length-1-r];
        }
        if (mat.length%2 == 1) {
            sum -= mat[mat.length/2][mat.length/2];
        }
        return sum;
    }
}