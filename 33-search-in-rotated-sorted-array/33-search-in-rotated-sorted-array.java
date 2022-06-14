class Solution {
    public int search(int[] nums, int target) {
        //find min
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi) {
            int mid = lo - (lo - hi) / 2;
            if (nums[mid] > nums[nums.length-1]) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        
        int minIndex = lo;
        // System.out.println(minIndex);
        
        //find target
        if (target > nums[nums.length-1]) {
            lo = 0;
            hi = minIndex-1;
        }
        else {
            lo = minIndex;
            hi = nums.length-1;
        }
        
        while (lo <= hi) {
            int mid = lo - (lo - hi)/2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        
        return -1;
    }
}