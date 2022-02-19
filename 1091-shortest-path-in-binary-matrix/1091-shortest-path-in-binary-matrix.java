class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] != 0) {
            return -1;
        }
        
        Queue<Integer> rQ = new ArrayDeque();
        Queue<Integer> cQ = new ArrayDeque();
        Queue<Integer> distQ = new ArrayDeque();
        rQ.add(0);
        cQ.add(0);
        distQ.add(1);
        
        final int[] dr = {-1,-1,-1, 0, 0, 1, 1,1};
        final int[] dc = {-1, 0, 1, -1,1, -1,0,1};
        
        while (rQ.size() > 0) {
            int curR = rQ.poll();
            int curC = cQ.poll();
            int dist = distQ.poll();
            // System.out.println(String.format("cur: (%d, %d)", curR, curC));
            if (curR == grid.length-1
               && curC == grid[0].length-1) {
                return dist;
            }
            for (int i=0; i<8; i++) {
                int r = curR+dr[i];
                int c = curC+dc[i];
                if (r >= 0
                   && c >= 0
                   && r <grid.length
                   && c <grid[0].length
                   && grid[r][c] == 0) {
                    rQ.add(r);
                    cQ.add(c);
                    distQ.add(dist+1);
                    grid[r][c] = 1;
                }
            }
        }
        
        return -1;
    }
}
/*

[
[0,1,1,0,0,0],
[0,1,0,1,1,0],
[0,1,1,0,1,0],
[0,0,0,1,1,0],
[1,1,1,1,1,0],
[1,1,1,1,1,0]
]

[
[0,0,0],
[1,1,0],
[1,1,1]
]
*/