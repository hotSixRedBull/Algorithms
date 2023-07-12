class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Set<Integer>> adj = new ArrayList();
        List<Set<Integer>> reverse = new ArrayList();
        for (int i=0; i<n; i++) {
            adj.add(new HashSet());
            reverse.add(new HashSet());
        }
        
        for (int cur=0; cur<n; cur++) {
            int[] g = graph[cur];
            for (int i=0; i<g.length; i++) {
                adj.get(cur).add(g[i]);
                reverse.get(g[i]).add(cur);
            }
        }
        
        Queue<Integer> q = new ArrayDeque();
        for (int i=0; i<n; i++) {
            if (adj.get(i).size() == 0) {
                q.add(i);
            }
        }
        // System.out.println(q);
        List<Integer> result = new ArrayList();
        while (q.size() > 0) {
            Queue<Integer> nq = new ArrayDeque();
            for (int cur : q) {
                result.add(cur);
                for (int follower : reverse.get(cur)) {
                    adj.get(follower).remove(cur);
                    if (adj.get(follower).size() == 0) {
                        nq.add(follower);
                    }
                }
            }
            
            System.out.println(nq);
            q = nq;
        }
        Collections.sort(result);
        return result;
    }
}

/*
[[0],[2,3,4],[3,4],[0,4],[]]
*/