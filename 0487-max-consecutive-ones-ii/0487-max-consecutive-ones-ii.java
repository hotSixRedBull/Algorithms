class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int prev = 0;
        int cur = 0;
        int max = 0;
        boolean zeroExists = false;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 0) {
                zeroExists = true;
                max = Math.max(max, prev+cur+1);
                prev = cur;
                cur = 0;
            }
            else {
                cur++;
                max = Math.max(max, cur);
            }
        }
        if (zeroExists) {
            max = Math.max(max, prev+cur+1);
        }
        else {
            max = Math.max(max, cur);
        }
        
        return max;
    }
}

/*
check prev and current length;

*/