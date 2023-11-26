class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] consecutive = new int[m][n];
        for (int col=0; col<n; col++) {
            consecutive[m-1][col] = matrix[m-1][col] == 1 ? 1 : 0;
            for (int row=m-2; row>=0; row--) {
                if (matrix[row][col] == 0) {
                    consecutive[row][col] = 0;
                }
                else {
                    consecutive[row][col] = consecutive[row+1][col]+1;
                }
            }
        }
        
        
        // for (int i=0; i<m; i++) {
        //     System.out.println(Arrays.toString(consecutive[i]));
        // }
        
        int max = 0;
        for (int i=0; i<m; i++) {
            Arrays.sort(consecutive[i]);
            for (int j=n-1; j>=0; j--) {
                int cur = (n-1-j+1)*consecutive[i][j];
                max = Math.max(max, cur);
            }
        }
        
        return max;
    }
}