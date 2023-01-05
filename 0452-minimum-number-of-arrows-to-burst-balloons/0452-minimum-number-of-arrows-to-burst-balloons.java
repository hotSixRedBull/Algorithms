class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        Arrays.sort(points, (a, b) -> {
           if (a[0] == b[0]) {
               return a[1] > b[1] ? 1 : -1;
           } 
            return a[0] > b[0] ? 1 : -1;
        });
        
        int shot = 1;
        int[] prev = new int[]{points[0][0], points[0][1]};
        for (int[] point : points) {
            if (prev[1] < point[0]) {
                shot++;
                prev = new int[]{point[0], point[1]};
            }
            else {
                prev[0] = Math.max(prev[0], point[0]);
                prev[1] = Math.min(prev[1], point[1]);
            }
            // System.out.println(String.format("prev: %s, point: %s, shot: %d", Arrays.toString(prev),Arrays.toString(point), shot));
        }
        
        return shot;
    }
}