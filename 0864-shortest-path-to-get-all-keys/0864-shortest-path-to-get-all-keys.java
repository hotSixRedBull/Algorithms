class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        
        int keyCnt = 0;
        int foundAll = 0;
        int[] start = new int[]{0,0};
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                char cur = grid[r].charAt(c);
                if (cur >='a' && cur <='f') {
                    keyCnt++;
                    foundAll |= (1 << (cur-'a'));
                }
                if (cur == '@') {
                    start[0] = r;
                    start[1] = c;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{start[0],start[1],0,-1});
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        Map<Integer, Set<Pair<Integer, Integer>>> visit = new HashMap();
        visit.put(0, new HashSet());
        visit.get(0).add(new Pair<>(start[0], start[1]));
        while (q.size() > 0) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int state = cur[2];
            int move = cur[3];
            if (state == foundAll) {
                return move;
            }
            
            char signal = grid[r].charAt(c);
            // lock
            if (signal >= 'A' && signal <= 'F') {
                int mask = 1 << (signal - 'A');
                if ((state & mask) == 0) {
                    continue;
                }
            }
            int newState = state;
            if (signal >= 'a' && signal <= 'f') {
                newState |= (1 << (signal-'a'));
                visit.putIfAbsent(newState, new HashSet());
            }
            
            for (int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                Pair<Integer, Integer> next = new Pair<>(nr, nc);
                if (nr < 0 || nc < 0 || nr >= m || nc >= n
                   || grid[nr].charAt(nc) == '#'
                   || visit.get(newState).contains(next)) {
                    continue;
                }
                visit.get(newState).add(next);
                q.add(new int[]{nr,nc,newState,move+1});
            }
        }
        
        return -1;
    }
}