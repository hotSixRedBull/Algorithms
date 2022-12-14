class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[][] dp = new int[nums.length][2];
        dp[0][1] = nums[0];
        dp[1][0] = nums[0];
        dp[1][1] = nums[1];
        for (int i = 2; i<nums.length; i++) {
            dp[i][0] = Math.max(dp[i-1][1], dp[i-1][0]);
            dp[i][1] = Math.max(Math.max(dp[i-2][0]+nums[i], dp[i-1][0]), dp[i-2][1]+nums[i]);
        }
        return Math.max(dp[nums.length-1][0], dp[nums.length-1][1]);
    }
}