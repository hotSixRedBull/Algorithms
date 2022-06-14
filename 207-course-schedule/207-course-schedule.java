class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[][] adj = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;
            adj[prerequisite[1]][prerequisite[0]] = 1;
        }
        Queue<Integer> q = new ArrayDeque();
        for (int i=0; i<numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        int left = numCourses;
        while (q.size() > 0) {
            int cur = q.poll();
            left--;
            for (int i=0; i<numCourses; i++) {
                if (adj[cur][i] == 1) {
                    indegree[i]--;
                    if (indegree[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }
        
        return left == 0;
    }
}