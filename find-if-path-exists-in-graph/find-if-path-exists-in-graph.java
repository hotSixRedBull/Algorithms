class Solution {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        HashMap<Integer, ArrayList<Integer>> adjMap = new HashMap<>();
        for (int[] edge : edges) {
            if (adjMap.containsKey(edge[0])) {
                ArrayList<Integer> tmp = adjMap.get(edge[0]);
                tmp.add(edge[1]);
                adjMap.put(edge[0], tmp);
            }
            else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(edge[1]);
                adjMap.put(edge[0], tmp);
            }
            if (adjMap.containsKey(edge[1])) {
                ArrayList<Integer> tmp = adjMap.get(edge[1]);
                tmp.add(edge[0]);
                adjMap.put(edge[1], tmp);
            }
            else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(edge[0]);
                adjMap.put(edge[1], tmp);
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        Boolean[] visited = new Boolean[n+1];
        Arrays.fill(visited, false);
        q.add(start);
        visited[start] = true;
        while (q.size() > 0) {
            int cur = q.poll();
            if (cur == end) {
                return true;
            }
            if (adjMap.containsKey(cur)) {
                ArrayList<Integer> tmp = adjMap.get(cur);
                for (int next : tmp.toArray(new Integer[0])) {
                    if (!visited[next]) {
                        visited[next] = true;
                        q.add(next);    
                    }
                }
            }
        }
        return false;
    }
}