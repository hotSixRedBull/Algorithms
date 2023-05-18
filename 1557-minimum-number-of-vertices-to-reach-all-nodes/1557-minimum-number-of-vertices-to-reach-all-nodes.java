class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Map<Integer, List<Integer>> adj = new HashMap();
        int[] indegree = new int[n];
        for (List<Integer> edge : edges) {
            int from = edge.get(0);
            int to = edge.get(1);
            adj.putIfAbsent(from, new ArrayList());
            adj.get(from).add(to);
            indegree[to]++;
        }
        List<Integer> result = new ArrayList();
        for (int i=0; i<n; i++) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}