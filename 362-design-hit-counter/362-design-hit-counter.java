class HitCounter {
    PriorityQueue<Integer> pq;
    public HitCounter() {
        pq = new PriorityQueue();
    }
    
    public void hit(int timestamp) {
        pq.add(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (pq.size() > 0
               && pq.peek() <= timestamp-300) {
            pq.poll();
        }
        return pq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */