class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        int[] indegree = new int[n+1];
        List<List<Integer>> adj = new ArrayList();
        for (int i=0; i<=n; i++) {
            adj.add(new ArrayList());
        }
        for (int[] relation : relations) {
            indegree[relation[1]]++;
            adj.get(relation[0]).add(relation[1]);
        }
        
        Queue<Integer> q = new ArrayDeque();
        Queue<Integer> lq = new ArrayDeque();
        int calc = 0;
        for (int i=1; i<=n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                lq.add(1);
            }
        }
        
        int maxLevel = 0;
        while (q.size() > 0) {
            calc++;
            int cur = q.poll();
            int level = lq.poll();
            maxLevel = Math.max(maxLevel, level);
            for (int nei : adj.get(cur)) {
                if (indegree[nei] == 1) {
                    indegree[nei] = 0;
                    q.add(nei);
                    lq.add(level+1);
                }
                else {
                    indegree[nei]--;
                }
            }
        }
        if (calc < n) {
            return -1;
        }
        return maxLevel;
    }
}