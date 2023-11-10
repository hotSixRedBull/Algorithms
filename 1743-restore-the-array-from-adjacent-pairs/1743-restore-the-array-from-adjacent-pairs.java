class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, Integer> indegree = new HashMap();
        Map<Integer, Set<Integer>> adj = new HashMap();
        for (int[] pair : adjacentPairs) {
            int a = pair[0];
            int b = pair[1];
            indegree.put(a, indegree.getOrDefault(a, 0)+1);
            indegree.put(b, indegree.getOrDefault(b, 0)+1);
            adj.putIfAbsent(a, new HashSet());
            adj.putIfAbsent(b, new HashSet());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        
        Queue<Integer> q = new ArrayDeque();
        boolean isStart = true;
        int end = -1;
        for (int key : indegree.keySet()) {
            if (indegree.get(key) == 1) {
                if (isStart) {
                    q.add(key);
                    isStart = false;
                }
                else {
                    end = key;
                    break;
                }
            }
        }
        
        int[] ans = new int[indegree.size()];
        int ansIndex = 0;
        Set<Integer> visited = new HashSet();
        while (q.size() > 0) {
            int cur = q.poll();
            visited.add(cur);
            ans[ansIndex++] = cur;
            for (int nei : adj.get(cur)) {
                indegree.put(nei, indegree.get(nei)-1);
                if (!visited.contains(nei)) {
                   if (indegree.get(nei) == 1) {
                       q.add(nei);
                   }
                }
            }
        }
        ans[indegree.size()-1] = end;
        return ans;
    }
}