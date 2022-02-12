class Solution {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> indexMap = new HashMap();
        Set<String> possibilities = new HashSet();
        for (int i=nums.length-1; i>=0; i--) {
            // nums[i] - nums[j] == k, nums[j] == nums[i] - k
            if (indexMap.containsKey(nums[i] - k)) {
                int target = nums[i] - k;
                if (nums[i] > target) {
                    possibilities.add(String.format("%d,%d", nums[i], target));
                }
                else {
                    possibilities.add(String.format("%d,%d", target, nums[i]));
                }
            }
            // nums[j] - nums[i] == k, nums[j] == nums[i] + k
            if (indexMap.containsKey(nums[i] + k)) {
                int target = nums[i] + k;
                if (nums[i] > target) {
                    possibilities.add(String.format("%d,%d", nums[i], target));
                }
                else {
                    possibilities.add(String.format("%d,%d", target, nums[i]));
                }
            }
            indexMap.put(nums[i], i);
        }
        return possibilities.size();
    }
}