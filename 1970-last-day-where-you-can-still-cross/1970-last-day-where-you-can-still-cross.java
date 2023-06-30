class Solution {
    int r;
    int c;
    int[][] cells;
    int[] dr;
    int[] dc;
    public int latestDayToCross(int row, int col, int[][] cells) {
        this.r = row;
        this.c = col;
        this.cells = cells;
        this.dr = new int[]{0,1,0,-1};
        this.dc = new int[]{1,0,-1,0};
        
        int lo=0;
        int hi=cells.length-1;
        while (lo < hi) {
            int mid = (lo+hi+1)/2;
            if (havePath(mid)) {
                // System.out.println(String.format("havePath(%d): true", mid));
                lo = mid;
            }
            else {
                // System.out.println(String.format("havePath(%d): false", mid));
                hi = mid-1;
            }
        }
        return lo;
    }
    
    public boolean havePath(int day) {
        // System.out.println(String.format("havePath(%d)", day));
        int[][] grid = new int[r][c];
        for (int i=0; i<day; i++) {
            grid[cells[i][0]-1][cells[i][1]-1] = 1;
        }
        
        Stack<int[]> stk = new Stack();
        boolean[][] visited = new boolean[r][c];
        for (int i=0; i<c; i++) {
            if (grid[0][i] == 1) {
                continue;
            }
            stk.add(new int[]{0, i});
            visited[0][i] = true;
        }
        while (stk.size() > 0) {
            int[] cur = stk.pop();
            // System.out.println(String.format("cur: %s", Arrays.toString(cur)));
            if (cur[0] == r-1) {
                return true;
            }
            for (int i=0; i<4; i++) {
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];
                if (nr < 0 || nc < 0 || nr >= r || nc >= c || grid[nr][nc] == 1
                   || visited[nr][nc]) {
                    continue;
                }
                visited[nr][nc] = true;
                stk.add(new int[]{nr, nc});
            }
        }
        return false;
    }
}