class Solution {
    public int shortestBridge(int[][] grid) {
        Map<Integer, List<int[]>> points = new HashMap();
        points.put(1, new ArrayList());
        points.put(2, new ArrayList());
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        int groupNumber = 1;
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                if (visit[r][c] == false
                   && grid[r][c] == 1) {
                    Queue<int[]> q = new ArrayDeque();
                    q.add(new int[]{r,c});
                    visit[r][c] = true;
                    while (q.size() > 0) {
                        int[] cur = q.poll();
                        points.get(groupNumber).add(cur);
                        for (int i=0; i<4; i++) {
                            int nr = dr[i] + cur[0];
                            int nc = dc[i] + cur[1];
                            if (nr < 0
                               || nc < 0
                               || nr >= n
                               || nc >= n
                               || grid[nr][nc] == 0
                               || visit[nr][nc]) {
                                continue;
                            }
                            visit[nr][nc] = true;
                            q.add(new int[]{nr, nc});
                        }
                    }
                    groupNumber++;
                }
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int[] coor1 : points.get(1)) {
            for (int[] coor2 : points.get(2)) {
                min = Math.min(min, Math.abs(coor2[0]-coor1[0])+Math.abs(coor2[1]-coor1[1])-1);
            }
        }
        return min;
    }
}

/*
[1,1,1,1,1],
[1,0,0,0,1],
[1,0,1,0,1],
[1,0,0,0,1],
[1,1,1,1,1]


[1,0,0,0,1],
[1,0,0,0,0],
[1,0,0,0,0],
[1,0,0,0,0],
[1,1,1,1,0]
^ 좌측 상단 노드에서 BFS를 해야만 한다.

그냥 두 그룹의 모든 점들을 비교하자 맨하탄거리로.
*/