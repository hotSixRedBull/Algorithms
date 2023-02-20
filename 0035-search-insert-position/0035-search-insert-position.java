class Solution {
    public int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi) {
            int mid = lo - (lo - hi)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        if (nums[nums.length-1] < target) {
            return nums.length;
        }
        return lo;
    }
}