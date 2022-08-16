class SparseVector {
    public List<int[]> numsList;
    SparseVector(int[] nums) {
        this.numsList = new ArrayList();
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                numsList.add(new int[]{i, nums[i]});
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        List<int[]> another = vec.numsList;
        int ourPtr = 0;
        int theirPtr = 0;
        int sum = 0;
        while (ourPtr < numsList.size()
              && theirPtr < vec.numsList.size()) {
            if (numsList.get(ourPtr)[0] == vec.numsList.get(theirPtr)[0]) {
                sum += numsList.get(ourPtr)[1]*vec.numsList.get(theirPtr)[1];
                ourPtr++;
                theirPtr++;
            }
            else {
                if (numsList.get(ourPtr)[0] < vec.numsList.get(theirPtr)[0]) {
                    ourPtr++;
                }
                else {
                    theirPtr++;
                }
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);