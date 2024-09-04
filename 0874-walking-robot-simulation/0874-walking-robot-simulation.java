class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int maxDist = 0;
        Map<Integer, Set<Integer>> obs = new HashMap();
        for (int[] o : obstacles) {
            obs.putIfAbsent(-o[1], new HashSet());
            obs.get(-o[1]).add(o[0]);
        }
        int r = 0;
        int c = 0;
        int dir = 0;
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        for (int command : commands) {
            // System.out.println(String.format("%d, %d", r, c));
            switch (command) {
                case -2:
                    if (dir == 0) {
                        dir = 3;
                    }
                    else {
                        dir--;
                    }
                    break;
                case -1:
                    if (dir == 3) {
                        dir = 0;
                    }
                    else {
                        dir++;
                    }
                    break;
                default:
                    for (int i=0; i<command; i++) {
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];
                        if (obs.containsKey(nr)
                           && obs.get(nr).contains(nc)) {
                            break;
                        }
                        r = nr;
                        c = nc;
                    }
                    break;
            }
            maxDist = Math.max(maxDist, r*r+c*c);
        }
        // System.out.println(String.format("%d, %d", r, c));
        
        return maxDist;
    }
}