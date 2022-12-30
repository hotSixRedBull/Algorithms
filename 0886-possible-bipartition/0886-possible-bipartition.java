class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer, List<Integer>> map = new HashMap();
        for (int i=1; i<=n; i++) {
            map.put(i, new ArrayList());
        }
        for (int[] dislike : dislikes) {
            map.get(dislike[0]).add(dislike[1]);
            map.get(dislike[1]).add(dislike[0]);
        }
        int[] color = new int[n+1];
        boolean[] visited = new boolean[n+1];
        for (int i=1; i<=n; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            Queue<int[]> q = new ArrayDeque();
            q.add(new int[]{i, 1});
            while (q.size() > 0) {
                int[] cur = q.poll();
                color[cur[0]] = cur[1];
                for (int nei : map.get(cur[0])) {
                    if (color[nei] != 0
                       && color[nei] != cur[1]*-1) {
                        return false;
                    }
                    if (visited[nei]) {
                        continue;
                    }
                    visited[nei] = true;
                    q.add(new int[]{nei, cur[1]*-1});
                }
            }
        }
        
        return true;
    }
}