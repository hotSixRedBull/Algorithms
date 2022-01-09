class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            int mid = left - ((left-right)/2);
            if (nums[mid] < target) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        
        if (nums[left] != target) {
            return ans;
        }
        
        ans[0] = left;
        for (int i=left; i<nums.length; i++) {
            if (nums[i] == target) {
                ans[1] = i;
            }
            else {
                break;
            }
        }
        
        return ans;
    }
}