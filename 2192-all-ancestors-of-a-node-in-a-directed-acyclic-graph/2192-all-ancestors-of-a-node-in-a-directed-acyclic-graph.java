//saw solution, 
//TLE
class Solution {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // Initialize adjacency list for the graph
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Populate the adjacency list with reversed edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[to].add(from);
        }

        List<List<Integer>> ancestorsList = new ArrayList<>();

        // For each node, find all its ancestors (children in reversed graph)
        for (int i = 0; i < n; i++) {
            List<Integer> ancestors = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();
            findChildren(i, adjacencyList, visited);
            // Add visited nodes to the current nodes' ancestor list
            for (int node = 0; node < n; node++) {
                if (node == i) continue;
                if (visited.contains(node)) ancestors.add(node);
            }
            ancestorsList.add(ancestors);
        }

        return ancestorsList;
    }

    // Helper method to perform DFS and find all children of a given node
    private void findChildren(
        int currentNode,
        List<Integer>[] adjacencyList,
        Set<Integer> visitedNodes
    ) {
        // Mark current node as visited
        visitedNodes.add(currentNode);

        // Recursively traverse all neighbors
        for (int neighbour : adjacencyList[currentNode]) {
            if (!visitedNodes.contains(neighbour)) {
                findChildren(neighbour, adjacencyList, visitedNodes);
            }
        }
    }
}
/*
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] indegree = new int[n];
        Map<Integer, List<Integer>> adj = new HashMap();
        for (int[] edge : edges) {
            indegree[edge[1]]++;
            adj.putIfAbsent(edge[0], new ArrayList());
            adj.get(edge[0]).add(edge[1]);
        }
        
        Stack<Integer> stk = new Stack();
        Map<Integer, Set<Integer>> parents = new HashMap();
        for (int i=0; i<n; i++) {
            if (indegree[i] == 0) {
                stk.push(i);
                parents.put(i, new HashSet());
            }
        }
        
        while(stk.size() > 0) {
            int cur = stk.pop();
            List<Integer> childs = adj.getOrDefault(cur, new ArrayList());
            for (int child : childs) {
                parents.putIfAbsent(child, new HashSet());
                parents.get(child).addAll(parents.get(cur));
                parents.get(child).add(cur);
                stk.push(child);
            }
        }
        
        List<List<Integer>> ans = new ArrayList();
        for (int i=0; i<n; i++) {
            List<Integer> parentsList = new ArrayList(parents.get(i));
            Collections.sort(parentsList);
            ans.add(parentsList);
        }
        return ans;
    }
}
*/