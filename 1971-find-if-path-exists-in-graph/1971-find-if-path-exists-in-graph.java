class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, List<Integer>> conn = new HashMap();
        for (int i=0; i<n; i++) {
            conn.put(i, new ArrayList());
        }
        for (int[] e : edges) {
            conn.get(e[0]).add(e[1]);
            conn.get(e[1]).add(e[0]);
        }
        Queue<Integer> q = new ArrayDeque();
        boolean[] visited = new boolean[n];
        q.add(source);
        visited[source] = true;
        while (q.size() > 0) {
            int cur = q.poll();
            if (cur == destination) {
                return true;
            }
            for (int nei : conn.get(cur)) {
                if (visited[nei] == false) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        return false;
    }
}