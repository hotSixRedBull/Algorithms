class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[1001];
        Arrays.sort(nums);
        for (int num : nums) {
            dp[num]++;
        }
        for (int i=0; i<=target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i-num];
                }
            }
        }
        return dp[target];
    }
}

/*
A1. brute force, O(200^1000)
A2. DP
- 1: 1
- 2: 2 (1 1 , 2)
- 3: 4 (1 1 1 1, 1 1 2, 1 2 1, 2 1 1, 3, 2 2)

*/