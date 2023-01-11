class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        HashMap<Integer, Set<Integer>> adj = new HashMap();
        int[] inDegree = new int[n];
        HashMap<Integer, Set<Integer>> degreeToIndex = new HashMap();
        degreeToIndex.put(0, new HashSet());
        degreeToIndex.put(1, new HashSet());
        for (int[] edge : edges) {
            if (adj.containsKey(edge[0]) == false) {
                adj.put(edge[0], new HashSet());
            }
            adj.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
            if (inDegree[edge[1]] == 1) {
                degreeToIndex.get(inDegree[edge[1]]).add(edge[1]);
            }
            else {
                if (degreeToIndex.containsKey(inDegree[edge[1]]) == false) {
                    degreeToIndex.put(inDegree[edge[1]], new HashSet());
                }
                degreeToIndex.get(inDegree[edge[1]]-1).remove(edge[1]);
                degreeToIndex.get(inDegree[edge[1]]).add(edge[1]);
            }
            if (adj.containsKey(edge[1]) == false) {
                adj.put(edge[1], new HashSet());
            }
            adj.get(edge[1]).add(edge[0]);
            inDegree[edge[0]]++;
            if (inDegree[edge[0]] == 1) {
                degreeToIndex.get(inDegree[edge[0]]).add(edge[0]);
            }
            else {
                if (degreeToIndex.containsKey(inDegree[edge[0]]) == false) {
                    degreeToIndex.put(inDegree[edge[0]], new HashSet());
                }
                degreeToIndex.get(inDegree[edge[0]]-1).remove(edge[0]);
                degreeToIndex.get(inDegree[edge[0]]).add(edge[0]);
            }
        }
        
        // System.out.println(String.format("inDegree: %s", Arrays.toString(inDegree)));
        while (degreeToIndex.containsKey(1)
              && degreeToIndex.get(1).size() > 0) {
            // System.out.println("!!");
            Set<Integer> curSet = new HashSet(degreeToIndex.get(1));
            int cnt = 0;
            for (int cur : curSet) {
                // System.out.println(String.format("cur: %d", cur));
                if (cur == 0) {
                    cnt++;
                    continue;
                }
                if (hasApple.get(cur) != true) {
                    for (int nei : adj.get(cur)) {
                        // System.out.println(String.format("nei: %d", nei));
                        adj.get(nei).remove(cur);
                        if (nei == 0) {
                            continue;
                        }
                        degreeToIndex.get(inDegree[nei]).remove(nei);
                        degreeToIndex.get(inDegree[nei]-1).add(nei);
                        inDegree[nei]--;
                    }
                    adj.remove(cur);
                    degreeToIndex.get(1).remove(cur);
                }
                else {
                    cnt++;
                }
            }
            if (cnt == curSet.size()) {
                break;
            }
        }
        // System.out.println(String.format("inDegree: %s", Arrays.toString(inDegree)));
        
        Queue<Integer> q = new ArrayDeque();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        int dist = 0;
        while (q.size() > 0) {
            int cur = q.poll();
            // System.out.println(String.format("cur : %d", cur));
            if (adj.containsKey(cur)) {
                for (int nei : adj.get(cur)) {
                    if (!visited[nei]) {
                        visited[nei] = true;
                        dist += 2;
                        q.add(nei);
                    }
                }
            }
        }
        return dist;
    }
}

/*
5
[[0,1],[0,2],[1,3],[0,4]]
[false,false,false,true,false]
6
[[0,1],[1,2],[2,3],[3,4],[1,5]]
[false,false,false,false,false,true]
*/