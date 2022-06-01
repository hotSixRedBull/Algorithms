class Solution {
    public int minKnightMoves(int x, int y) {
        int[] dr = new int[]{-2,-1,1,2,2,1,-1,-2};
        int[] dc = new int[]{1,2,2,1,-1,-2,-2,-1};
        Queue<int[]> q = new ArrayDeque();
        Queue<Integer> sq = new ArrayDeque();
        boolean[][] visited = new boolean[607][607];
        int[] root = new int[]{0,0};
        q.add(root);
        sq.add(0);
        visited[300][300] = true;
        while (q.size() > 0) {
            int[] cur = q.poll();
            int step = sq.poll();
            if (cur[0] == x
               && cur[1] == y) {
                return step;
            }
            for (int i=0; i<8; i++) {
                int[] next = new int[]{cur[0]+dr[i],cur[1]+dc[i]};
                if (next[0] >= -300
                    && next[0] <= 300
                    && next[1] >= -300
                    && next[1] <= 300
                    && visited[next[0]+300][next[1]+300] == false) {
                    q.add(next);
                    sq.add(step+1);
                    visited[next[0]+300][next[1]+300] = true;
                }
            }
        }
        return 0;
    }
}