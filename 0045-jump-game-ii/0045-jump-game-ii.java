class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 0;
        for (int i=nums.length-2; i>=0; i--) {
            int min = Integer.MAX_VALUE;
            for (int j=1; j<=nums[i]; j++) {
                if (i+j >= nums.length) {
                    break;
                }
                min = Math.min(min, dp[i+j]);
            }
            dp[i] = min != Integer.MAX_VALUE ? min+1 : Integer.MAX_VALUE;
        }
        return dp[0];
    }
}