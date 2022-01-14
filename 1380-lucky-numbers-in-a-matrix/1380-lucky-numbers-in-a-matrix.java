class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        for (int r=0; r<matrix.length; r++) {
            int min = matrix[r][0];
            int minC = 0;
            for (int c=0; c<matrix[r].length; c++) {
                if (min > matrix[r][c]) {
                    minC = c;
                    min = matrix[r][c];
                }
            }
            
            int max = min;
            boolean isMax = false;
            for (int r2 = 0; r2<matrix.length; r2++) {
                if (r2 != r && matrix[r2][minC] > matrix[r][minC]) {
                    break;
                }
                if (r2 == matrix.length-1) {
                    isMax = true;
                }
            }
            
            if (isMax) {
                list.add(matrix[r][minC]);
            }
        }
        
        return list;
    }
}