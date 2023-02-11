class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer, List<Integer>> rAdj = new HashMap();
        HashMap<Integer, List<Integer>> bAdj = new HashMap();
        for (int i=0; i<n; i++) {
            rAdj.put(i, new ArrayList());
            bAdj.put(i, new ArrayList());
        }
        
        for (int[] rEdge : redEdges) {
            rAdj.get(rEdge[0]).add(rEdge[1]);
        }
        
        for (int[] bEdge : blueEdges) {
            bAdj.get(bEdge[0]).add(bEdge[1]);
        }
        
        int[] ans = new int[n];
        for (int i=1; i<n; i++) {
            ans[i] = -1;
        }
        boolean[] redVisited = new boolean[n];
        boolean[] blueVisited = new boolean[n];
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{0,0,1}); //pos, dist, color (1 for red, -1 for blue)
        q.add(new int[]{0,0,-1}); //pos, dist, color (1 for red, -1 for blue)
        redVisited[0] = true;
        blueVisited[0] = true;
        while (q.size() > 0) {
            int[] cur = q.poll();
            int pos = cur[0];
            int dist = cur[1];
            int color = cur[2];
            if (ans[pos] == -1) {
                ans[pos] = dist;
            }
            if (color == 1) {
                for (int bNode : bAdj.get(pos)) {
                    if (blueVisited[bNode]) {
                        continue;
                    }
                    blueVisited[bNode] = true;
                    q.add(new int[]{bNode, dist+1, color*-1});
                }
            }
            else {
                for (int rNode : rAdj.get(pos)) {
                    if (redVisited[rNode]) {
                        continue;
                    }
                    redVisited[rNode] = true;
                    q.add(new int[]{rNode, dist+1, color*-1});
                }
            }
        }
        return ans;
    }
}