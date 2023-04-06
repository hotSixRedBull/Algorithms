class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        int cnt = 0;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 0
                   && visit[r][c] == false) {
                    // System.out.println(String.format("%d,%d",r,c));
                    boolean containsBorder = false;
                    Queue<int[]> q = new ArrayDeque();
                    q.add(new int[]{r,c});
                    visit[r][c] = true;
                    while (q.size() > 0) {
                        int[] cur = q.poll();
                        // System.out.println(String.format("%d,%d",cur[0],cur[1]));
                        if (cur[0] == 0
                           || cur[0] == m-1
                           || cur[1] == 0
                           || cur[1] == n-1) {
                            containsBorder = true;
                        }
                        
                        for (int i=0; i<4; i++) {
                            int nr = cur[0] + dr[i];
                            int nc = cur[1] + dc[i];
                            // System.out.println(String.format("next: %d,%d",nr,nc));
                            if (nr < 0
                               || nc < 0
                               || nr >= m
                               || nc >= n
                               || grid[nr][nc] == 1
                               || visit[nr][nc]) {
                                continue;
                            }
                            visit[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                    if (!containsBorder) {
                        // System.out.println(String.format("%d,%d is closed",r,c));
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}