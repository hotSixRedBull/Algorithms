class Solution {
    public boolean check(int[] nums) {
        int stop = -1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                stop = i;
                break;
            }
        }
        
        //Not rotated
        if (stop == -1) {
            return true;
        }
        
        for (int i=stop+1; i<nums.length; i++) {
            if (nums[i] < nums[i-1]) {
                return false;
            }
            stop++;
        }
        
        return stop == nums.length - 1 && nums[nums.length-1] <= nums[0];
    }
}