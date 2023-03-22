class Solution {
    public int minScore(int n, int[][] roads) {
        HashMap<Integer, List<int[]>> adj;
        adj = new HashMap();
        for (int[] road : roads) {
            adj.putIfAbsent(road[0], new ArrayList());
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.putIfAbsent(road[1], new ArrayList());
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        // System.out.println(adj);
        
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new ArrayDeque();
        q.add(1);
        visited[1] = true;
        int min = Integer.MAX_VALUE;
        while(q.size() > 0) {
            int cur = q.poll();
            for (int[] nei : adj.get(cur)) {
                min = Math.min(min, nei[1]);
                if (visited[nei[0]] == false) {
                    visited[nei[0]] = true;
                    min = Math.min(min, nei[1]);
                    q.add(nei[0]);
                }
            }
        }
        
        return min;
    }
}