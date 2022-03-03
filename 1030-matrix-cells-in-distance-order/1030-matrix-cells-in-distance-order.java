class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] matrix = new int[rows][cols];
        for (int i=0; i<rows; i++) {
            matrix[i] = new int[cols];
            Arrays.fill(matrix[i], 0);
        }
        
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        Queue<Integer> rq = new ArrayDeque();
        Queue<Integer> cq = new ArrayDeque();
        rq.add(rCenter);
        cq.add(cCenter);
        int[][] ans = new int[rows*cols][2];
        int ansIndex = 0;
        ans[ansIndex++] = new int[]{rCenter, cCenter};
        matrix[rCenter][cCenter] = 1;
        while (rq.size() > 0) {
            int r = rq.poll();
            int c = cq.poll();
            for (int i=0; i<4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if (nextR >= 0
                   && nextC >= 0
                   && nextR <rows
                   && nextC <cols
                   && matrix[nextR][nextC] == 0) {
                    matrix[nextR][nextC] = 1;
                    rq.add(nextR);
                    cq.add(nextC);
                    ans[ansIndex++] = new int[]{nextR, nextC};
                }
            }
        }
        return ans;
    }
}