class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int n = nums.length;
        int lo=0;
        int hi=n-1;
        while (lo < hi) {
            int mid = lo - (lo-hi)/2;
            if (nums[mid] < target) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        if (nums[lo] != target) {
            return false;
        }
        int leftMost = lo;
        lo = 0;
        hi = n-1;
        while (lo < hi) {
            int mid = (lo+hi+1)/2;
            if (nums[mid] <= target) {
                lo = mid;
            }
            else {
                hi = mid-1;
            }
        }
        int rightMost = lo;
        if (rightMost-leftMost+1 > n/2) {
            return true;
        }
        return false;
    }
}