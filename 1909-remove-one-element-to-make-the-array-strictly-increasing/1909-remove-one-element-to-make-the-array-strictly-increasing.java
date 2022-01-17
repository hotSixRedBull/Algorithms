class Solution {
    public boolean canBeIncreasing(int[] nums) {
        int cnt = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (cnt > 1) {
                return false;
            }
            if (nums[i] >= nums[i+1]) {
                if (cnt == 0) {
                    if (i > 0) {
                        if (nums[i-1] < nums[i+1] 
                            || (i+2 < nums.length && nums[i] < nums[i+2])
                            || (i+2 == nums.length)) {
                            cnt++;
                            continue;
                        }
                        else {
                            return false;
                        }
                    }
                    else {
                        cnt++;
                        continue;
                    }
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}