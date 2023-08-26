class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        int n = maze[0].length;
        boolean[][][] visit = new boolean[m][n][4];
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        Queue<int[]> q = new ArrayDeque();
        q.add(start);
        while (q.size() > 0) {
            int[] cur = q.poll();
            // System.out.println(Arrays.toString(cur));
            if (cur[0] == destination[0]
               && cur[1] == destination[1]) {
                return true;
            }
            for (int i=0; i<4; i++) {
                // System.out.println("i: "+i);
                if (visit[cur[0]][cur[1]][i] == true) {
                    continue;
                }
                visit[cur[0]][cur[1]][i] = true;
                int[] base = new int[]{cur[0],cur[1]};
                while(true) {
                    // System.out.println(String.format(">>base: %s", Arrays.toString(base)));
                    int nr = base[0]+dr[i];
                    int nc = base[1]+dc[i];
                    // System.out.println(String.format("nr,nc: %d,%d",nr,nc));
                    if (nr < 0 || nc < 0
                       || nr >= m || nc >= n
                       || maze[nr][nc] == 1) {
                        break;
                    }
                    base[0] = nr;
                    base[1] = nc;
                }
                // System.out.println(String.format("base: %s, cur: %s", Arrays.toString(base),Arrays.toString(cur)));
                if (base[0] != cur[0]
                   || base[1] != cur[1]) {
                    q.add(base);
                    visit[base[0]][base[1]][reverseDir(i)] = true;
                }
            }
        }
        return false;
    }
    public int reverseDir(int dir) {
        if (dir == 0) {
            return 2;
        }
        else if (dir == 1) {
            return 3;
        }
        else if (dir == 2) {
            return 0;
        }
        else {
            return 1;
        }
    }
}