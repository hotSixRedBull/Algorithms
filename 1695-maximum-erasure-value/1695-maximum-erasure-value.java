class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        Set<Integer> set = new HashSet();
        int sum = 0;
        int maxSum = 0;
        while (right < nums.length) {
            while (left < right
                   && set.contains(nums[right])) {
                set.remove(nums[left]);
                sum-=nums[left];
                left++;
            }
            set.add(nums[right]);
            sum += nums[right];
            right++;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}