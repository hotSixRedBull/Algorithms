class RandomizedSet {
    TreeSet<Integer> set;
    public RandomizedSet() {
        set = new TreeSet();
    }
    
    public boolean insert(int val) {
        if (set.contains(val)) {
            return false;
        }
        set.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (set.contains(val) == false) {
            return false;
        }
        set.remove(val);
        return true;
    }
    
    public int getRandom() {
        Integer[] arr = set.toArray(new Integer[set.size()]);
        // System.out.println(Arrays.deepToString(arr));
        int index = (int) (Math.random()*(set.size()*100));
        index = (int) Math.floor(index/100);
        return arr[index];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */