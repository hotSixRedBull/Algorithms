class Solution {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int index = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<points.length; i++) {
            int[] point = points[i];
            if (x == point[0]) {
                int diff = Math.abs(y-point[1]);
                if (diff < ans) {
                    index = i;
                    ans = diff;
                }
            }
            if (y == point[1]) {
                int diff = Math.abs(x-point[0]);
                if (diff < ans) {
                    index = i;
                    ans = diff;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : index;
    }
}