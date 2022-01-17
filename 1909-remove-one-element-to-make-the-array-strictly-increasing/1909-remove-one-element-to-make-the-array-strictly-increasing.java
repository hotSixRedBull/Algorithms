class Solution {
    public boolean canBeIncreasing(int[] nums) {
        boolean extraLife = true;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                continue;
            }
            else if (extraLife) {
                if (i > 0) {
                    if (nums[i-1] < nums[i+1] 
                        || (i+2 < nums.length && nums[i] < nums[i+2])
                        || (i+2 == nums.length)) {
                        extraLife = false;
                        continue;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    extraLife = false;
                    continue;
                }
            }
            else {
                return false;
            }
        }
        return true;
    }
}