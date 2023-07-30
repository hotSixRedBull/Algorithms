class Solution {
    public int missingElement(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo+hi-1)/2;
            int rear = mid+1;
            if (nums[mid]-nums[0]-mid < k
               && nums[rear]-nums[0]-mid > k) {
                return nums[0]+k+mid;
            }
            else if (nums[mid]-nums[0]-mid < k) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        if (lo == nums.length-1) {
            return nums[0]+k+nums.length-1;
        }
        return -1;
    }
}
