class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for (int num : nums) {
            if (num == 1) {
                cnt++;
            }
        }
        //make window
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i=0; i<cnt; i++) {
            if (nums[i] == 0) {
                cnt0++;
            }
            else {
                cnt1++;
            }
        }
        
        int min = cnt0;
        for (int i=cnt; i<n; i++) {
            if (nums[i-cnt] == 0) {
                cnt0--;
            }
            else {
                cnt1--;
            }
            if (nums[i] == 0) {
                cnt0++;
            }
            else {
                cnt1++;
            }
            min = Math.min(min, cnt0);
        }
        
        for (int i=0; i<cnt; i++) {
            int prev = n-cnt+i;
            if (nums[prev] == 0) {
                cnt0--;
            }
            else {
                cnt1--;
            }
            if (nums[i] == 0) {
                cnt0++;
            }
            else {
                cnt1++;
            }
            min = Math.min(min, cnt0);
        }
        
        return min;
    }
}