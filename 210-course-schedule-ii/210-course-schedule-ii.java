class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList();
        for (int i=0; i<numCourses; i++) {
            adj.add(new ArrayList());
        }
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }
        int[] answer = new int[numCourses];
        int index = 0;
        Queue<Integer> q = new ArrayDeque();
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (q.size() > 0) {
            int cur = q.poll();
            answer[index++] = cur;
            for (int nei : adj.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        
        if (index != numCourses) {
            return new int[0];
        }
        return answer;
    }
}