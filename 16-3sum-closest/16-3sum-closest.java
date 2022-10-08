class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int sum = Integer.MAX_VALUE;
        for (int i=1; i<nums.length-1; i++) {
            int left = 0;
            int right = nums.length-1;
            while (left < i
                   && i < right) {
                int localSum = nums[left]+nums[i]+nums[right];
                int localDiff = Math.abs(target-localSum);
                if (localDiff == 0) {
                    return target;
                }
                else if (localDiff < minDiff) {
                    minDiff = localDiff;
                    sum = localSum;
                }
                else if (target < localSum) {
                    right--;
                }
                else {
                    left++;
                }
            }
        }
        
        return sum;
    }
}
/*
A1. brute force
not working 1000C3 => 1000*999*998/6

A2. Sort and two pointer?


A3. 
*/