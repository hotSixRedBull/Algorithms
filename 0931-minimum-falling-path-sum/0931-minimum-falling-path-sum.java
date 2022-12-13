class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] prev = matrix[0];
        for (int r=1; r<matrix.length; r++) {
            int[] next = Arrays.copyOf(matrix[r], matrix.length);
            next[0] += Math.min(prev[0], prev[1]);
            for (int c=1; c<matrix.length-1; c++) {
                next[c] += Math.min(Math.min(prev[c-1], prev[c]), prev[c+1]);
            }
            next[n-1] += Math.min(prev[n-2], prev[n-1]);
            prev = next;
        }
        int min = Integer.MAX_VALUE;
        for (int c=0; c<n; c++) {
            min = Math.min(min, prev[c]);
        }
        return min;
    }
}