class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int max = 1;
        int cnt = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i-1] < nums[i]) {
                cnt++;
            }
            else {
                cnt = 1;
            }
            max = Math.max(max, cnt);
        }
        return max;
    }
}