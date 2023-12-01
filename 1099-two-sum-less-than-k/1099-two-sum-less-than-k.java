class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int max = -1;
        int n = nums.length;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                if (nums[i]+nums[j] < k) {
                    max = Math.max(max, nums[i]+nums[j]);
                }
            }
        }
        return max;
    }
}