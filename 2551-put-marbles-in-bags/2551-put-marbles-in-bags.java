class Solution {
    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        PriorityQueue<Integer> rpq = new PriorityQueue(Collections.reverseOrder());
        for (int i=1; i<weights.length; i++) {
            pq.add(weights[i-1]+weights[i]);
            rpq.add(weights[i-1]+weights[i]);
        }
        long min = 0;
        long max = 0;
        for (int i=0; i<k-1; i++) {
            min += pq.poll();
            max += rpq.poll();
        }
        return max-min;
    }
}