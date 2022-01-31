class Solution {
    public int countQuadruplets(int[] nums) {
        HashMap<Integer, List<Integer>> indexMap = new HashMap();
        for (int i=0; i<nums.length; i++) {
            if (!indexMap.containsKey(nums[i])) {
                indexMap.put(nums[i], new ArrayList());
            }
            indexMap.get(nums[i]).add(i);
        }
        int cnt = 0;
        for (int i=0; i<nums.length-3; i++) {
            for (int j=i+1; j<nums.length-2; j++) {
                for (int k=j+1; k<nums.length-1; k++) {
                    int sum = nums[i]+nums[j]+nums[k];
                    if (indexMap.containsKey(sum)) {
                        for (int index : indexMap.get(sum)) {
                            if (index > k) {
                                cnt++;
                            }   
                        }
                    }
                }
            }
        }
        return cnt;
    }
}
/*
[9,6,8,23,39,23]
*/