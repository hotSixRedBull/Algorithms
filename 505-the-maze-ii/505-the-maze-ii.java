class Solution {
    int[] dr;
    int[] dc;
    int[][] visited;
    public Solution() {
        dr = new int[]{-1,0,1,0};
        dc = new int[]{0,1,0,-1};
        visited = new int[100][100];
    }
    
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        // if destination doesn't have wall on its neibor slots, it cannot be arrived.
        int wallCnt = 0;
        for (int i=0; i<4; i++) {
            int nr = destination[0]+dr[i];
            int nc = destination[1]+dc[i];
            if (nr < 0
               || nc < 0
               || nr >= maze.length
               || nc >= maze[0].length) {
                wallCnt++;
                continue;
            }
            if (maze[nr][nc] == 1) {
                wallCnt++;
            }
        }
        if (wallCnt == 0) {
            return -1;
        }
        
        int min = backtracking(maze, start, destination, 0);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
    
    public int backtracking(int[][] m, int[] s, int[] d, int depth) {
        // System.out.println(">>>>");
        // System.out.println(String.format("%s, %d", Arrays.toString(s), depth));
        // System.out.println(">>>>");
        if (s[0] == d[0]
           && s[1] == d[1]) {
            return depth;
        }
        visited[s[0]][s[1]] = depth;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<4; i++) {
            int nr = s[0]+dr[i];
            int nc = s[1]+dc[i];
            // System.out.println(Arrays.toString(s));
            // System.out.println(String.format("nr: %d, nc: %d, depth: %d",nr,nc,depth));
            if (nr < 0
               || nc < 0
               || nr >= m.length
               || nc >= m[0].length) {
                continue;
            }
            if (m[nr][nc] == 0
                && (visited[nr][nc] == 0
                    || visited[nr][nc] > depth)) {
                int[] prev = new int[]{s[0], s[1]};
                int dist = 0;
                while (nr >= 0
                      && nc >= 0
                      && nr < m.length
                      && nc < m[0].length
                      && m[nr][nc] != 1) {
                    dist++;
                    prev[0] = nr;
                    prev[1] = nc;
                    nr = nr + dr[i];
                    nc = nc + dc[i];
                }
                // visited[prev[0]-dr[i]][prev[1]-dc[i]] = depth+dist;
                // System.out.println(String.format("prev: %s, depth+dist: %d", Arrays.toString(prev), depth+dist));
                if (visited[prev[0]][prev[1]] > 0
                    && visited[prev[0]][prev[1]] < depth+dist) {
                    // System.out.println("continue");
                    continue;
                }
                int localAns = backtracking(m, new int[]{prev[0], prev[1]}, d, depth+dist);
                min = Math.min(min, localAns);
            }
        }
        return min;
    }
}

/*
[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
[0,4]
[4,4]
[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
[0,4]
[3,2]
[[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]]
[4,3]
[0,1]
[[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]]
[1,1]
[1,2]
*/