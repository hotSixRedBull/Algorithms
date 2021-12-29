class Solution {
    public int findMiddleIndex(int[] nums) {
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        
        int acc = 0;
        for (int i=0; i<nums.length; i++) {
            if (sum-acc-nums[i] == acc) {
                return i;
            }
            acc += nums[i];
        }
        
        return -1;
    }
}