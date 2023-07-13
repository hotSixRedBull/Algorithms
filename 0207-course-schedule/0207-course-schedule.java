class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Map<Integer, List<Integer>> adj = new HashMap();
        for (int i=0; i<numCourses; i++) {
            adj.put(i, new ArrayList());
        }
        for (int[] p : prerequisites) {
            indegree[p[0]]++;
            adj.get(p[1]).add(p[0]);
        }
        Queue<Integer> q = new ArrayDeque();
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        Set<Integer> classesTook = new HashSet();
        while (q.size() > 0) {
            int cur = q.poll();
            classesTook.add(cur);
            for (int nei : adj.get(cur)) {
                indegree[nei]--;
                if (indegree[nei] == 0) {
                    q.add(nei);
                }
            }
        }
        
        return classesTook.size() == numCourses;
    }
}