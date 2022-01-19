class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int ans = -1;
        for (int num : nums) {
            if (min < num) {
                ans = Math.max(ans, num - min);
            }
            min = Math.min(min, num);
        }
        return ans;
    }
}