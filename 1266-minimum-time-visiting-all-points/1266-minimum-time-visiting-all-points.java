class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int[] prev = points[0];
        int ans = 0;
        for (int i=1; i<points.length; i++) {
            int[] cur = points[i];
            int diffX = Math.abs(cur[0]-prev[0]);
            int diffY = Math.abs(cur[1]-prev[1]);
            if (diffX > diffY) {
                ans += diffX;
            }
            else {
                ans += diffY;
            }
            prev = cur;
        }
        return ans;
    }
}