class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap();
        int n = nums.length;
        int max = 0;
        int i=0;
        for (int j=0; j<n; j++) {
            while (cnt.getOrDefault(nums[j], 0) == k) {
                if (cnt.get(nums[i]) == 1) {
                    cnt.remove(nums[i]);
                }
                else {
                    cnt.put(nums[i], cnt.getOrDefault(nums[i], 0)-1);
                }
                i++;
            }
            cnt.put(nums[j], cnt.getOrDefault(nums[j], 0)+1);
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}