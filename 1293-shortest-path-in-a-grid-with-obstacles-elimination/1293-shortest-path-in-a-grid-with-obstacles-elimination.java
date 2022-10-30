class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new ArrayDeque();
        boolean[][][] visited = new boolean[n][m][k+1];
        
        q.add(new int[]{0,0,0,k}); //r,c,dist,left
        visited[0][0][k] = true;
        
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        
        int min = Integer.MAX_VALUE;
        while (q.size() > 0) {
            int[] cur = q.poll();
            int left = cur[3];
            if (cur[0] == n-1
               && cur[1] == m-1) {
                min = Math.min(min, cur[2]);
            }
            if (grid[cur[0]][cur[1]] == 1) {
                left--;
                if (left < 0) {
                    continue;
                }    
            }
            for (int i=0; i<4; i++) {
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if (nr < 0
                   || nc < 0
                   || nr >= n
                   || nc >= m
                   || visited[nr][nc][left]) {
                    continue;
                }
                q.add(new int[]{nr,nc,cur[2]+1,left});
                visited[nr][nc][left] = true;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}