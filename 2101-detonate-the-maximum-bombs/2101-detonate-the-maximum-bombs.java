class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        Map<Integer, List<Integer>> adj = new HashMap();
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) {
                    continue;
                }
                if (dist(bombs[i], bombs[j]) <= (double) bombs[i][2]) {
                    adj.putIfAbsent(i, new ArrayList());
                    adj.get(i).add(j);
                }
            }
        }
        
        int max = 0;
        for (int i=0; i<n; i++) {
            Queue<Integer> q = new ArrayDeque();
            boolean[] visit = new boolean[n];
            int connected = 0;
            q.add(i);
            visit[i] = true;
            while (q.size() > 0) {
                int cur = q.poll();
                connected++;
                List<Integer> neis = adj.getOrDefault(cur, new ArrayList());
                for (int nei : neis) {
                    if (!visit[nei]) {
                        visit[nei] = true;
                        q.add(nei);
                    }
                }
            }
            max = Math.max(max, connected);
        }
        return max;
    }
    public double dist(int[] a, int[] b) {
        double r = Math.pow(Math.abs(a[0]-b[0]), 2);
        double c = Math.pow(Math.abs(a[1]-b[1]), 2);
        return Math.sqrt(r+c);
    }
}