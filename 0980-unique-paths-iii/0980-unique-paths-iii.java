class Solution {
    int ans;
    int[] goal;
    int[] dr;
    int[] dc;
    int m;
    int n;
    int length;
    
    public int uniquePathsIII(int[][] grid) {
        // global
        m = grid.length;
        n = grid[0].length;
        ans = 0;
        Stack<int[]> stk = new Stack();
        boolean[][] visited = new boolean[m][n];
        dr = new int[]{-1,0,1,0};
        dc = new int[]{0,1,0,-1};
        length = m*n;
        
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 2) {
                    goal = new int[]{r,c};
                }
                else if (grid[r][c] == 1) {
                    stk.push(new int[]{r,c});
                    visited[r][c] = true;
                }
                else if (grid[r][c] == -1) {
                    visited[r][c] = true;
                    length--;
                }
            }
        }
        countPaths(grid, visited, stk, 0);
        return ans;
    }
    
    public void countPaths(int[][] grid,
                          boolean[][] visited,
                          Stack<int[]> stk,
                          int len) {
        int[] cur = stk.pop();
        len++;
        // System.out.println(String.format("cur: %s", Arrays.toString(cur)));
        if (len == length
            && cur[0] == goal[0]
            && cur[1] == goal[1]) {
            ans++;
            return;
        }
        for (int i=0; i<4; i++) {
            int nr = cur[0] + dr[i];
            int nc = cur[1] + dc[i];
            // System.out.println(String.format("nr: %s, nc: %s", nr, nc));
            if (nr < 0
               || nr >= m
               || nc < 0
               || nc >= n
               || visited[nr][nc]) {
                continue;
            }
            visited[nr][nc] = true;
            stk.push(new int[]{nr, nc});
            countPaths(grid, visited, stk, len);
            visited[nr][nc] = false;
        }
    }
}