class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] leftSum = new int[n+1];
        int[] rightSum = new int[n+1];
        for (int i=0; i<n; i++) {
            leftSum[i+1] = leftSum[i] + nums[i];
            rightSum[n-1-i] = rightSum[n-i] + nums[n-1-i];
        }
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            long cur = 0;
            if (i > 0) {
                long left = nums[i]*(i) - leftSum[i];
                cur += left;
            }
            if (i < n-1) {
                long right = rightSum[i+1] - nums[i]*(n-i-1);
                cur += right;
            }
            result[i] = (int) cur;
        }
        return result;
    }
}