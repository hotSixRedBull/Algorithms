class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Collections.reverseOrder());
        for (int pile : piles) {
            pq.offer(pile);
        }
        for (int i=0; i<k; i++) {
            int peek = pq.poll();
            peek -= (int)Math.floor(peek/2);
            pq.offer(peek);
        }
        int sum = 0;
        while (pq.size() > 0) {
            sum += pq.poll();
        }
        return sum;
    }
}