class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque();
        q.add(0);
        visited[0] = true;
        int cnt = 0;
        while (q.size() > 0) {
            int cur = q.poll();
            cnt++;
            if (cnt == n) {
                return true;
            }
            for (int nei : rooms.get(cur)) {
                if (visited[nei] == false) {
                    visited[nei] = true;
                    q.add(nei);
                }
            }
        }
        
        return false;
    }
}