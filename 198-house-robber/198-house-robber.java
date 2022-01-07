class Solution {
    public int rob(int[] nums) {
        int max = nums[0];
        for (int i=0; i<nums.length; i++) {
            if (i > 2) {
                nums[i] = Math.max(nums[i-2], nums[i-3]) + nums[i];
            }
            else if (i > 1) {
                nums[i] = nums[i-2]+nums[i];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}