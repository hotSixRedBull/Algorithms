class Solution {
    public int smallestCommonElement(int[][] mat) {
        for (int c=0; c<mat[0].length; c++) {
            int cnt = 1;
            int target = mat[0][c];
            for (int r=1; r<mat.length; r++) {
                if (Arrays.binarySearch(mat[r], target) >= 0) {
                    cnt++;
                }                
            }
            if (cnt == mat.length) {
                return target;
            }
        }
        return -1;
    }
}