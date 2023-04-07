class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        int cnt = 0;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] != 1
                   || visit[r][c]) {
                    continue;
                }
                int cell = 0;
                boolean isConnectedToBorder = false;
                Queue<int[]> q = new ArrayDeque();
                q.add(new int[]{r,c});
                visit[r][c] = true;
                while (q.size() > 0) {
                    int[] cur = q.poll();
                    cell++;
                    if (cur[0] == 0
                       || cur[1] == 0
                       || cur[0] == m-1
                       || cur[1] == n-1) {
                        isConnectedToBorder = true;
                    }
                    for (int i=0; i<4; i++) {
                        int nr = cur[0]+dr[i];
                        int nc = cur[1]+dc[i];
                        if (nr < 0
                           || nc < 0
                           || nr >= m
                           || nc >= n
                           || visit[nr][nc]
                           || grid[nr][nc] == 0) {
                            continue;
                        }
                        q.add(new int[]{nr,nc});
                        visit[nr][nc] = true;
                    }
                }
                if (!isConnectedToBorder) {
                    cnt+=cell;
                }
            }
        }
        return cnt;
    }
}