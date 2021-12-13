class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int max = -1;
        // System.out.println(Arrays.toString(nums));
        for (int i=0; i<nums.length; i++) {
            // System.out.println("nums[i]: "+nums[i]);
            if (nums[i] >= k) {
                continue;
            }
            
            int left = i+1;
            int right = nums.length-1;
            while (left <= right) {
                int mid = (int)((left+right)/2);
                // System.out.println("nums[mid]: "+nums[mid]);
                if (nums[mid] < k-nums[i]) {
                    max = Math.max(max, nums[i]+nums[mid]);
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
        }
        return max;
    }
}