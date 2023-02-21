class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        // System.out.println(">>>start");
        while (lo <= hi) {
            int mid = lo - (lo - hi)/2;
            // System.out.println("mid: "+mid);
            if (isAppearOnce(nums, mid)) {
                return nums[mid];
            }
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid-1]) {
                    lo = mid+1;
                }
                else {
                    hi = mid-1;
                }
            }
            else {
                if (mid == nums.length-1) {
                    hi = mid-1;
                }
                else if (mid < nums.length-1 && nums[mid] == nums[mid+1]) {
                    lo = mid+1;
                }
                else {
                    hi = mid-1;
                }
            }
        }
        return -1;
    }
    
    boolean isAppearOnce(int[] nums, int index) {
        if (index == 0 && (nums.length == 1 ||(nums.length > 1 && nums[index+1] != nums[index]))) {
            return true;
        }
        if (index == nums.length-1 && nums.length > 1 && nums[index-1] != nums[index]) {
            return true;
        }
        if (index > 0 && index < nums.length-1 && nums[index] != nums[index-1] && nums[index] != nums[index+1]) {
            return true;
        }
        return false;
    }
}