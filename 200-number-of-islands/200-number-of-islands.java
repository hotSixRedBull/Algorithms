class Solution {
    public int numIslands(char[][] grid) {
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        int cnt = 0;
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[0].length; c++) {
                if (grid[r][c] == '1') {
                    cnt++;
                    Queue<int[]> q = new ArrayDeque();
                    q.add(new int[]{r,c});
                    while (q.size() > 0) {
                        int[] cur = q.poll();
                        if (grid[cur[0]][cur[1]] == '0') {
                            continue;
                        }
                        grid[cur[0]][cur[1]] = '0';
                        for (int i=0; i<4; i++) {
                            int nr = cur[0] + dr[i];
                            int nc = cur[1] + dc[i];
                            if (nr < 0
                               || nc < 0
                               || nr >= grid.length
                               || nc >= grid[0].length) {
                                continue;
                            }
                            if (grid[nr][nc] == '1') {
                                q.add(new int[]{nr, nc});
                            }
                        }
                    }
                }
            }
        }
        return cnt;
    }
}