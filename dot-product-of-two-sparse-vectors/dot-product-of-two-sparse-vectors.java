class SparseVector {
    private Set<Integer> indexSet;
    private List<Integer> values;
    SparseVector(int[] nums) {
        indexSet = new TreeSet<>();
        values = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                indexSet.add(i);
            }
            values.add(nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        this.indexSet.retainAll(vec.getIndexSet());
        List<Integer> vecValues = vec.getValues();
        int ret = 0;
        for (int index : this.indexSet) {
            ret += this.values.get(index)*vecValues.get(index);
        }
        return ret;
    }
    
    public List<Integer> getValues() {
        return this.values;
    }
    
    public Set<Integer> getIndexSet() {
        return this.indexSet;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);