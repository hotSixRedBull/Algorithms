class Solution {
    class wbpair {
        int dist;
        int widx; //worker index
        int bidx; //bike index
        public wbpair(int a, int b, int c) {
            dist = a;
            widx = b;
            bidx = c;
        }
        public String toString() {
            return String.format("dist: %d, widx: %d, bidx: %d",
                                dist,
                                widx,
                                bidx);
        }
    }
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<List<Pair<Integer, Integer>>> wTobList = new ArrayList();
        int[] closest = new int[1001];
        PriorityQueue<wbpair> pq = new PriorityQueue<>(new Comparator<wbpair>() {
            @Override
            public int compare(wbpair a, wbpair b) {
                if (a.dist != b.dist) {
                    return a.dist-b.dist;
                }
                else if (a.widx != b.widx) {
                    return a.widx-b.widx;
                }
                else {
                    return a.bidx-b.bidx;
                }
            }
        });
        
        for (int w=0; w<workers.length; w++) {
            List<Pair<Integer, Integer>> blist = new ArrayList();
            for (int b=0; b<bikes.length; b++) {
                int dist = Math.abs(workers[w][0]-bikes[b][0])+Math.abs(workers[w][1]-bikes[b][1]);
                blist.add(new Pair(dist, b));
            }
            Collections.sort(blist, Comparator.comparing(Pair::getKey));
            wTobList.add(blist);
            closest[w] = 0;
            Pair<Integer, Integer> bike = wTobList.get(w).get(closest[w]++);
            pq.add(new wbpair(bike.getKey(), w, bike.getValue()));
        }
        
        boolean[] bikeUsed = new boolean[bikes.length];
        int[] workerStatus = new int[workers.length];
        Arrays.fill(workerStatus, -1);
        
        while (!pq.isEmpty()) {
            wbpair pair = pq.remove();
            // System.out.println(String.format("pair: %s",pair));
            
            int worker = pair.widx;
            int bike = pair.bidx;
            
            // System.out.println(String.format("worker: %s",worker));
            // System.out.println(String.format("workerStatus: %s",Arrays.toString(workerStatus)));
            if (workerStatus[worker] == -1
               && !bikeUsed[bike]) {
                bikeUsed[bike] = true;
                workerStatus[worker] = bike;
            }
            else {
                Pair<Integer, Integer> bikePair = wTobList.get(worker).get(closest[worker]++);
                pq.add(new wbpair(bikePair.getKey(), worker, bikePair.getValue()));
            }
        }
        
        return workerStatus;
    }
}