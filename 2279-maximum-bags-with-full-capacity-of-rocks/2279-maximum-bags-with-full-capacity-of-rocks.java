class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        int n = capacity.length;
        for (int i=0; i<n; i++) {
            pq.offer(capacity[i]-rocks[i]);
        }
        
        int cnt = 0;
        while (pq.size() > 0) {
            int cur = pq.poll();
            if (cur > additionalRocks) {
                break;
            }
            additionalRocks -= cur;
            cnt++;
        }
        return cnt;
    }
}