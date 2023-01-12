class Solution {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        HashMap<Integer, List<Integer>> adj = new HashMap();
        for (int[] edge : edges) {
            if (adj.containsKey(edge[0]) == false) {
                adj.put(edge[0], new ArrayList());
            }
            adj.get(edge[0]).add(edge[1]);
            if (adj.containsKey(edge[1]) == false) {
                adj.put(edge[1], new ArrayList());
            }
            adj.get(edge[1]).add(edge[0]);
        }
        int[] answer = new int[n];
        boolean[] v = new boolean[n];
        v[0] = true;
        backtracking(n, adj, labels, 0, answer, v);
        return answer;
    }
    
    public HashMap<Character, Integer> backtracking(int n,
                                                    HashMap<Integer, List<Integer>> adj,
                                                    String labels,
                                                    int cur,
                                                    int[] answer,
                                                    boolean[] visited) {
        HashMap<Character, Integer> ret = new HashMap();
        ret.put(labels.charAt(cur), 1);
        answer[cur] = 1;
        if (adj.containsKey(cur) == false) {
            return ret;
        }
        for (int child : adj.get(cur)) {
            if (visited[child]) {
                continue;
            }
            visited[child] = true;
            HashMap<Character, Integer> childMap = backtracking(n, adj, labels, child, answer, visited);
            answer[cur] += childMap.getOrDefault(labels.charAt(cur), 0);
            // System.out.println(String.format("childMap for %d : %s", child, childMap));
            for (char key : childMap.keySet()) {
                if (ret.containsKey(key) == false) {
                    ret.put(key, childMap.get(key));
                }
                else {
                    ret.put(key, ret.get(key) + childMap.get(key));
                }
            }
        }
        return ret;
    }
}

/*
4
[[0,2],[0,3],[1,2]]
"aeed"

*/