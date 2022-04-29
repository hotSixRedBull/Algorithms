class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] group = new int[graph.length];
        boolean[] visit = new boolean[graph.length];
        Stack<Integer> stk = new Stack();
        Stack<Integer> colorStk = new Stack();
        for (int i=0; i<graph.length; i++) {
            stk.push(i);
            colorStk.push(1);
        }
        
        while (stk.size() > 0) {
            int cur = stk.pop();
            int color = colorStk.pop();
            if (visit[cur]) {
                continue;
            }
            group[cur] = color;
            visit[cur] = true;
            for (int i=0; i<graph[cur].length; i++) {
                if (visit[graph[cur][i]] == false) {
                    stk.push(graph[cur][i]);
                    colorStk.push(color*-1);
                }
                else if (group[graph[cur][i]] != color*-1) {
                    return false;
                }
            }
        }
        
        return true;
    }
}