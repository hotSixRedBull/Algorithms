class RecentCounter {
    Queue<Long> q;
    public RecentCounter() {
        q = new ArrayDeque();
    }
    
    public int ping(int t) {
        q.add(Long.valueOf(t));
        while (q.size() > 0 && q.peek() < t-3000) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */