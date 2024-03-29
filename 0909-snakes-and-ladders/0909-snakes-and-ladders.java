class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean left = true;
        int cnt = 1;
        HashMap<Integer, Integer> map = new HashMap();
        for (int r=n-1; r>=0; r--) {
            if (left) {
                for (int c=0; c<n; c++) {
                    if (board[r][c] != -1) {
                        map.put(cnt, board[r][c]);
                    }
                    cnt++;
                }
            }
            else {
                for (int c=n-1; c>=0; c--) {
                    if (board[r][c] != -1) {
                        map.put(cnt, board[r][c]);
                    }
                    cnt++;
                }
            }
            left ^= true;
        }
        
        Queue<Integer> q = new ArrayDeque();
        Queue<Integer> nq = new ArrayDeque();
        Set<Integer> visit = new HashSet();
        q.add(1);
        int move = 0;
        while (q.size() > 0) {
            int pos = q.poll();
            // System.out.println(pos);
            if (pos > n*n) {
                continue;
            }
            if (pos == n*n) {
                return move;
            }
            if (visit.contains(pos)) {
                if (q.size() == 0) {
                    // System.out.println("--level change");
                    q = nq;
                    nq = new ArrayDeque();
                    move++;
                }
                continue;
            }
            visit.add(pos);
            for (int d=1; d<7; d++) {
                int next = pos+d;
                if (map.containsKey(next)) {
                    nq.add(map.get(next));
                }
                else {
                    nq.add(next);
                }
            }
            if (q.size() == 0) {
                // System.out.println("--level change");
                q = nq;
                nq = new ArrayDeque();
                move++;
            }
        }
        return -1;
    }
}

/*
[[1,1,-1],[1,1,1],[-1,1,1]]
[[-1,7,-1],[-1,6,9],[-1,-1,2]]
[[-1,1,2,-1],[2,13,15,-1],[-1,10,-1,-1],[-1,6,2,8]]
[[-1,-1,19,10,-1],[2,-1,-1,6,-1],[-1,17,-1,19,-1],[25,-1,20,-1,-1],[-1,-1,-1,-1,15]]
[[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
[[-1,-1,-1,46,47,-1,-1,-1],[51,-1,-1,63,-1,31,21,-1],[-1,-1,26,-1,-1,38,-1,-1],[-1,-1,11,-1,14,23,56,57],[11,-1,-1,-1,49,36,-1,48],[-1,-1,-1,33,56,-1,57,21],[-1,-1,-1,-1,-1,-1,2,-1],[-1,-1,-1,8,3,-1,6,56]]
[[-1,-1,-1,135,-1,-1,-1,-1,-1,185,-1,-1,-1,-1,105,-1],[-1,-1,92,-1,-1,-1,-1,-1,-1,201,-1,118,-1,-1,183,-1],[-1,-1,-1,-1,-1,-1,-1,-1,-1,179,-1,-1,-1,-1,-1,-1],[-1,248,-1,-1,-1,-1,-1,-1,-1,119,-1,-1,-1,-1,-1,192],[-1,-1,104,-1,-1,-1,-1,-1,-1,-1,165,-1,-1,206,104,-1],[145,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,229,-1],[-1,-1,75,140,-1,-1,-1,-1,-1,-1,-1,-1,43,-1,34,-1],[-1,-1,-1,-1,-1,-1,169,-1,-1,-1,-1,-1,-1,188,-1,-1],[-1,-1,-1,-1,-1,-1,92,-1,171,-1,-1,-1,-1,-1,-1,66],[-1,-1,-1,126,-1,-1,68,-1,-1,-1,-1,-1,-1,-1,-1,-1],[-1,109,-1,86,28,228,-1,-1,144,-1,-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,59,-1,-1,-1,-1,-1,51,-1,-1,-1,62,-1],[-1,71,-1,-1,-1,63,-1,-1,-1,-1,-1,-1,212,-1,-1,-1],[-1,-1,-1,-1,174,-1,59,-1,-1,-1,-1,-1,-1,133,-1,-1],[-1,-1,62,-1,5,-1,16,-1,-1,-1,-1,-1,-1,-1,-1,-1],[-1,-1,-1,59,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1]]
[[-1,-1,-1,46,47,-1,-1,-1],[51,-1,-1,63,-1,31,21,-1],[-1,-1,26,-1,-1,38,-1,-1],[-1,-1,11,-1,14,23,56,57],[11,-1,-1,-1,49,36,-1,48],[-1,-1,-1,33,56,-1,57,21],[-1,-1,-1,-1,-1,-1,2,-1],[-1,-1,-1,8,3,-1,6,56]]
*/