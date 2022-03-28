class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return target == nums[0];
        }
        Arrays.sort(nums);
        int lo = 0;
        int hi = nums.length-1;
        
        while (lo <= hi) {
            int mid = lo-(lo-hi)/2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                lo = mid+1;
            }
            else if (nums[mid] > target) {
                hi = mid-1;
            }
        }
        
        return false;
    }
}