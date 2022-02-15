class Solution {
    public boolean checkValid(int[][] matrix) {
        for (int r=0; r<matrix.length; r++) {
            Set<Integer> s1 = new HashSet();
            Set<Integer> s2 = new HashSet();
            for (int c=0; c<matrix.length; c++) {
                s1.add(matrix[r][c]);
                s2.add(matrix[c][r]);
            }
            if (s1.size() != matrix.length || s2.size() != matrix.length) {
                return false;
            }
        }
        return true;
    }
}