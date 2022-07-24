class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0; i<matrix.length; i++) {
            int lo = 0;
            int hi = matrix[i].length-1;
            while (lo <= hi) {
                int mid = lo - (lo - hi) / 2;
                if (matrix[i][mid] == target) {
                    return true;
                }
                else if (matrix[i][mid] < target) {
                    lo = mid+1;
                }
                else {
                    hi = mid-1;
                } 
            }
        }
        return false;
    }
}