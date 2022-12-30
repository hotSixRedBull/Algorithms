class Solution {
    List<List<Integer>> answer;
    int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        answer = new ArrayList();
        n = graph.length;
        List<Integer> built = new ArrayList();
        built.add(0);
        findPathRecursive(graph, built, new HashSet(built));
        return answer;
    }
    public void findPathRecursive(int[][] graph,
                                  List<Integer> built,
                                 Set<Integer> visited) {
        // System.out.println(built);
        int last = built.get(built.size()-1);
        if (last == n-1) {
            answer.add(new ArrayList(built));
            return;
        }
        for (int neighbor : graph[last]) {
            if (!visited.contains(neighbor)) {
                built.add(neighbor);
                visited.add(neighbor);
                findPathRecursive(graph, built, visited);
                built.remove(built.size()-1);
                visited.remove(neighbor);
            }
        }
    }
}