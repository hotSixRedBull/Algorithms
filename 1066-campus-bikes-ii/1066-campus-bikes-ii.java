class Solution {
    HashMap<Integer, Integer> cache;
    int[][] dists;
    public int assignBikes(int[][] workers, int[][] bikes) {
        cache = new HashMap();
        dists = new int[workers.length][bikes.length];
        for (int w=0; w<workers.length; w++) {
            for (int b=0; b<bikes.length; b++) {
                dists[w][b] = Math.abs(workers[w][0]-bikes[b][0]) + Math.abs(workers[w][1] - bikes[b][1]);
            }
        }
        return subProb(workers, bikes, 0, 0);
    }
    
    public int subProb(int[][] workers,
                       int[][] bikes,
                       int state,
                       int workerIndex) {
        if (workerIndex >= workers.length) {
            return 0;
        }
        if (cache.containsKey(state) != false) {
            return cache.get(state);
        }
        
        int localSub = Integer.MAX_VALUE;
        for (int i=0; i<bikes.length; i++) {
            // System.out.println(String.format("state: %s, state & (1<<i): %d", Integer.toString(state, 2), (state & (1 << i))));
            if ((state & (1 << i)) != 0) {
                continue;
            }
            localSub = Math.min(localSub, dists[workerIndex][i] + subProb(workers, bikes, (state | (1 << i)), workerIndex+1));
        }
        // System.out.println(String.format("localSub: %d", localSub));
        cache.put(state, localSub);
        return localSub;
    }
}