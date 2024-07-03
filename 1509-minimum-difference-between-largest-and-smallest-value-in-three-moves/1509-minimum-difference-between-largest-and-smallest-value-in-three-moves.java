class Solution {
    public int minDifference(int[] nums) {
        if (nums.length <= 3) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for (int right=0; right<4; right++) {
            int left = 3-right;
            int rightIndex = nums.length-right-1;
            if (left < 0 
                || left >= nums.length
                || rightIndex < 0) {
                break;
            }
            min = Math.min(min, nums[rightIndex]-nums[left]);
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}