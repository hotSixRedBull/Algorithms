class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        HashMap<Integer, List<int[]>> adj = new HashMap();
        for (int i=0; i<n; i++) {
            adj.put(i, new ArrayList());
        }
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        
        Queue<Integer> q = new ArrayDeque();
        Queue<Integer> dq = new ArrayDeque();
        Queue<Integer> jq = new ArrayDeque();
        Map<Integer, Integer> visit = new HashMap();
        q.add(src);
        dq.add(0);
        jq.add(0);
        int min = Integer.MAX_VALUE;
        while (q.size() > 0) {
            int cur = q.poll();
            int dist = dq.poll();
            int jump = jq.poll();
            // System.out.println(String.format("cur: %d, dist: %d", cur, dist));
            if (cur == dst) {
                min = Math.min(min, dist);
            }
            if (visit.containsKey(cur)) {
                int saved = visit.get(cur);
                if (saved < dist) {
                  continue;  
                }
            }
            visit.put(cur, dist);
            if (jump > k) {
                continue;
            }
            for (int[] nei :adj.get(cur)) {
                q.add(nei[0]);
                dq.add(nei[1] + dist);
                jq.add(jump + 1);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}