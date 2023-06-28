class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] dists = new double[n];
        Arrays.fill(dists, Double.MIN_VALUE);
        
        Map<Integer, Map<Integer, Integer>> adj = new HashMap();
        for (int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            adj.putIfAbsent(edge[0], new HashMap());
            adj.putIfAbsent(edge[1], new HashMap());
            adj.get(edge[0]).put(edge[1], i);
            adj.get(edge[1]).put(edge[0], i);
        }
        
        //{cur}
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> dists[b] < dists[a] ? -1 : 1);
        dists[start] = 1;
        Map<Integer, Integer> candidates = adj.getOrDefault(start, new HashMap());
        for (int key : candidates.keySet()) {
            dists[key] = dists[start]*succProb[candidates.get(key)];
            pq.add(key);
        }
        while (pq.size() > 0) {
            int cur = pq.poll();
            candidates = adj.getOrDefault(cur, new HashMap());
            for (int key : candidates.keySet()) {
                double nextProb = dists[cur]*succProb[candidates.get(key)];
                if (nextProb > dists[key]) {
                    dists[key] = nextProb;
                    pq.add(key);
                }
            }
        }
        return dists[end];
    }
}