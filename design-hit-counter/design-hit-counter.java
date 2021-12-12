class HitCounter {
    private Queue<Integer> q;
    public HitCounter() {
        q = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        while (this.q.size() > 0 && this.q.peek() < timestamp-300) {
            this.q.poll();
        }
        this.q.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        while (this.q.size() > 0 && this.q.peek() < timestamp-300) {
            this.q.poll();
        }
        
        Iterator<Integer> iterator = this.q.iterator();
        int res = 0;
        while (iterator.hasNext()) {
            if (iterator.next() > timestamp-300) {
                res++;
            }
        }
        return res;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */