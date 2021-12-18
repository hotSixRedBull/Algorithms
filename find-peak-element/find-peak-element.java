class Solution {
    public int findPeakElement(int[] nums) {
        int prev = Integer.MIN_VALUE;
        int ans = -1;
        if (nums.length == 1) {
            return 0;
        }
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1] && prev < nums[i]) {
                ans = i;
                break;
            }
            prev = nums[i];
        }
        if (ans == -1) {
            if (nums.length >= 2 && nums[nums.length-1] > nums[nums.length-2]) {
                ans = nums.length-1;
            }
        }
        return ans;
    }
}