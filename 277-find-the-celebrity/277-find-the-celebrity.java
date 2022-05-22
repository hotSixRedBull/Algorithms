/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int[] indegree = new int[n];
        boolean[] isNormal = new boolean[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) {
                    continue;
                }
                if (knows(j, i)) {
                    indegree[i]++;
                    isNormal[j] = true;
                    // break;
                }
            }
        }
        // System.out.println(Arrays.toString(indegree));
        // System.out.println(Arrays.toString(isNormal));
        for (int i=0; i<n; i++) {
            if (indegree[i] == n-1
               && !isNormal[i]) {
                return i;
            }
        }
        return -1;
    }
}