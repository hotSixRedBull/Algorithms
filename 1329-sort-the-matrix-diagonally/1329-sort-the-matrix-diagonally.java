class Solution {
    public int[][] diagonalSort(int[][] mat) {
        for (int c=0; c<mat[0].length; c++) {
            PriorityQueue<Integer> pq = new PriorityQueue();
            // search
            for (int r=0; r<mat.length && r+c < mat[0].length; r++) {
                pq.add(mat[r][r+c]);
            }
            // fill
            for (int r=0; pq.size()>0; r++) {
                mat[r][r+c] = pq.poll();
            }
        }
        for (int r=1; r<mat.length; r++) {
            PriorityQueue<Integer> pq = new PriorityQueue();
            for (int r2=0; r+r2<mat.length && r2<mat[0].length; r2++) {
                pq.add(mat[r+r2][r2]);
            }
            for (int r2=0; pq.size()>0; r2++) {
                mat[r+r2][r2] = pq.poll();
            }
        }
        return mat;
    }
}