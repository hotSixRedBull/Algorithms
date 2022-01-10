class TwoSum {
    HashMap<Integer, Integer> hashMap;
    PriorityQueue<Integer> pq;
    public TwoSum() {
        this.hashMap = new HashMap<>();
        this.pq = new PriorityQueue<>();
    }
    
    public void add(int number) {
        this.hashMap.put(number, this.hashMap.getOrDefault(number, 0)+1);
        this.pq.add(number);
    }
    
    public boolean find(int value) {
        for (int num : pq) {
            if (this.hashMap.containsKey(value-num)) {
                if (value-num == num) {
                    return this.hashMap.get(num) > 1;
                }
                return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */