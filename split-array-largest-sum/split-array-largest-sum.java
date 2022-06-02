class Solution {
    Integer[][] memo = new Integer[1001][51];
    
    private int getMinimumLargestSplitSum(int[] prefixSum, int currIndex, int subarrayCount) {
        int n = prefixSum.length - 1;
        
        if (memo[currIndex][subarrayCount] != null) {
            return memo[currIndex][subarrayCount];
        }
        
        if (subarrayCount == 1) {
            return memo[currIndex][subarrayCount] = prefixSum[n] - prefixSum[currIndex];
        }
        
        int minimumLargestSplitSum = Integer.MAX_VALUE;
        for (int i = currIndex; i <= n - subarrayCount; i++) {
            int firstSplitSum = prefixSum[i + 1] - prefixSum[currIndex];
            
            int largestSplitSum = Math.max(firstSplitSum, 
                                      getMinimumLargestSplitSum(prefixSum, i + 1, subarrayCount - 1));
            
            minimumLargestSplitSum = Math.min(minimumLargestSplitSum, largestSplitSum);
             
            if (firstSplitSum >= minimumLargestSplitSum) {
                break;
            }
        }
        
        return memo[currIndex][subarrayCount] = minimumLargestSplitSum;
    }
    
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        return getMinimumLargestSplitSum(prefixSum, 0, m);
    }
}