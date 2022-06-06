class Solution {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo <= hi) {
            int mid = lo - (lo - hi) / 2;
            if (nums[mid] > nums[nums.length-1]) {
                lo = mid + 1;
            }
            else {
                hi = mid -1;
            }
        }
        return nums[lo];
    }
}