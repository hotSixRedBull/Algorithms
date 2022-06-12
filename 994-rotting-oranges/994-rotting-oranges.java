class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque();
        int left = 0;
        int cnt = 0;
        
        int M = grid.length;
        int N = grid[0].length;
        for (int r=0; r<M; r++) {
            for (int c=0; c<N; c++) {
                if (grid[r][c] == 2) {
                    q.add(new int[]{r,c});
                }
                else if (grid[r][c] == 1) {
                    left++;
                }
            } 
        }
        
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        
        Queue<int[]> nextq = new ArrayDeque();
        if (q.size() > 0) {
            cnt--;
        }
        while (q.size() > 0) {
            int[] cur = q.poll();
            
            for (int i=0; i<4; i++) {
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if (nr >= 0
                   && nc >= 0
                   && nr < M
                   && nc < N
                   && grid[nr][nc] == 1) {
                    nextq.add(new int[]{nr, nc});
                    grid[nr][nc] = 2;
                    left--;
                }
            }
            
            if (q.size() == 0) {
                cnt++;
                q = nextq;
                nextq = new ArrayDeque();
            }
        }
        
        // System.out.println(left);
        if (left == 0) {
            return cnt;
        }
        else {
            return -1;
        }
    }
}