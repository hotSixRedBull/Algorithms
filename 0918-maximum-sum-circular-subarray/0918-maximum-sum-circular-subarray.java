class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        // kadane's algorithm
        int curSum = 0;
        for (int i=0; i<n; i++) {
            curSum += nums[i];
            max = Math.max(max, curSum);
            if (curSum < 0) {
                curSum = 0;
            }
        }
        
        // special sums
        int[] suffixSum = new int[n];
        int[] rightMax = new int[n];
        suffixSum[n-1] = nums[n-1];
        rightMax[n-1] = suffixSum[n-1];
        for (int i=n-2; i>=0; i--) {
            suffixSum[i] = suffixSum[i+1]+nums[i];
            rightMax[i] = Math.max(rightMax[i+1], suffixSum[i]);
        }
        
        int acc = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(max, acc+rightMax[i]);
            acc += nums[i];
        }
        
        return max;
    }
}

/*
reviewed kadene's algorithm
*/