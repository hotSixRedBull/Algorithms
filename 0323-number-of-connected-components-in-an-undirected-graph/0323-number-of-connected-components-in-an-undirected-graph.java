class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        int numberOfComp = 0;
        for (int i=0; i<n; i++) {
            if (visited[i] == true) {
                continue;
            }
            visited[i] = true;
            Queue<Integer> q = new ArrayDeque();
            q.add(i);
            while (q.size() > 0) {
                int cur = q.poll();
                for (int nei : adj.get(cur)) {
                    if (visited[nei] == false) {
                        q.add(nei);
                        visited[nei] = true;
                    }
                }
            }
            numberOfComp++;
        }
        return numberOfComp;
    }
}