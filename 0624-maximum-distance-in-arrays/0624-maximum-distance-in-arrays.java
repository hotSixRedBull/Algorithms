class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int m = arrays.size();
        PriorityQueue<int[]> minq = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        PriorityQueue<int[]> maxq = new PriorityQueue<int[]>((a, b) -> a[0] == b[0] ? a[1]-b[1] : b[0]-a[0]);
        for (int i=0; i<m; i++) {
            for (int j=0; j<arrays.get(i).size(); j++) {
                minq.add(new int[]{arrays.get(i).get(j), i});
                maxq.add(new int[]{arrays.get(i).get(j), i});
            }
        }
        int[] min = minq.poll();
        int[] max = maxq.poll();
        
        if (min[1] != max[1]) {
            return Math.abs(max[0]-min[0]);
        }
        else {
            int ans = 0;
            while (maxq.size() > 0) {
                int[] cur = maxq.poll();
                if (cur[1] != min[1]) {
                    ans = Math.max(ans, Math.abs(cur[0]-min[0]));
                    break;
                }
            }
            while (minq.size() > 0) {
                int[] cur = minq.poll();
                if (cur[1] != max[1]) {
                    ans = Math.max(ans, Math.abs(max[0]-cur[0]));
                    break;
                }
            }
            return ans;
        }
    }
}