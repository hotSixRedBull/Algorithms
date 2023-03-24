class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> bidirectional = new HashMap();
        Map<Integer, Set<Integer>> input = new HashMap();
        for (int[] connection : connections) {
            int a = connection[0];
            int b = connection[1];
            bidirectional.putIfAbsent(a, new ArrayList());
            bidirectional.putIfAbsent(b, new ArrayList());
            input.putIfAbsent(a, new HashSet());
            bidirectional.get(a).add(b);
            bidirectional.get(b).add(a);
            input.get(a).add(b);
        }
        
        Queue<Integer> q = new ArrayDeque();
        boolean[] visited = new boolean[n];
        q.add(0);
        visited[0] = true;
        int redirection = 0;
        while(q.size() > 0) {
            int cur = q.poll();
            for (int adj : bidirectional.get(cur)) {
                if (visited[adj]) {
                    continue;
                }
                if (input.containsKey(cur) == true
                   && input.get(cur).contains(adj) == true) {
                    redirection++;
                    // System.out.println(String.format("%d to %d redirection", cur, adj));
                }
                q.add(adj);
                visited[adj] = true;
            }
        }
        return redirection;
    }
}