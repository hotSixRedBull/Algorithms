class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList());
        }
        for (int[] time : times) {
            adj.get(time[0]-1).add(new int[]{time[1]-1, time[2]});
        }
        
        Queue<Integer> q = new ArrayDeque();
        Queue<Integer> distq = new ArrayDeque();
        boolean[] visited = new boolean[n];
        visited[k-1] = true;
        q.add(k-1);
        distq.add(0);
        int cnt = 1;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k-1] = 0;
        
        while (q.size() > 0) {
            int cur = q.poll();
            int acc = distq.poll();
            dist[cur] = Math.min(dist[cur], acc);
            // System.out.println(String.format("cur: %d, acc: %d", cur, acc));
            for (int[] nei : adj.get(cur)) {
                // System.out.println(String.format("nei: %s",Arrays.toString(nei)));
                if (visited[nei[0]] == false) {
                    visited[nei[0]] = true;
                    q.add(nei[0]);
                    distq.add(acc+nei[1]);
                    cnt++;
                }
                else if (acc+nei[1] < dist[nei[0]]) {
                    q.add(nei[0]);
                    distq.add(acc+nei[1]);
                }
            }
        }
        // System.out.println(Arrays.toString(dist));
        if (cnt == n) {
            int max = 0;
            for (int i=0; i<n; i++) {
                if (i == k-1) {
                    continue;
                }
                max = Math.max(max, dist[i]);
            }
            return max;
        }
        else {
            return -1;
        }
    }
}