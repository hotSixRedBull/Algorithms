class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n];
        int i = 0;
        while (i < n) {
            if (nums[i] == 0) {
                i++;
                continue;
            }
            int start = i;
            int end = i;
            while (end < n && nums[end] == 1) {
                end++;
            }
            int count = end < n && nums[end] == 1 ? end-start+1 : end-start;
            for (int index = start; index<end; index++) {
                cnt[index] = count;
            }
            if (end < n && nums[end] == 1) {
                cnt[end] = count;
                i = end+1;
            }
            else {
                i = end;
            }
        }
        
        int max = 0;
        for (i=0; i<n; i++) {
            if (nums[i] == 1) {
                max = Math.max(max, cnt[i]-1);
            }
            else {
                int left = i == 0 ? 0 : cnt[i-1];
                int right = i == n-1 ? 0 : cnt[i+1];
                max = Math.max(max, left+right);
            }
        }
        return max;
    }
}