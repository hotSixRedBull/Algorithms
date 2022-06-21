class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int[] acc = new int[heights.length];
        for (int i=1; i<heights.length; i++) {
            if (heights[i-1] < heights[i]) {
                acc[i] = acc[i-1]+heights[i]-heights[i-1];
            }
            else {
                acc[i] = acc[i-1];
            }
        }
        // System.out.println(String.format("acc: %s", Arrays.toString(acc)));
        PriorityQueue<Integer> pq = new PriorityQueue();
        int maxSum = 0;
        int farthest = 0;
        for (int i=1; i<heights.length; i++) {
            int diff = heights[i]-heights[i-1];
            if (diff <= 0) {
                farthest = i;
                continue;
            }
            if (pq.size() < ladders) {
                pq.add(diff);
                maxSum += diff;
            }
            else if (pq.size() > 0
                     && pq.peek() < diff) {
                maxSum -= pq.poll();
                pq.add(diff);
                maxSum += diff;
            }
            // System.out.println(String.format("i: %d, acc[i]-maxSum: %d", i, acc[i]-maxSum));
            if (acc[i]-maxSum > bricks) {
                break;
            }
            farthest = i;
        }
        return farthest;
    }
}