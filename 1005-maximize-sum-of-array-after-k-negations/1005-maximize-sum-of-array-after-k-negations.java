class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int end = Math.min(nums.length, k);
        boolean zeroExists = false;
        if (nums.length < k) {
            for (int i=0; i<nums.length; i++) {
                if (nums[i] < 0) {
                    nums[i] = -nums[i];
                    k--;
                }
                else if (nums[i] == 0) {
                    zeroExists = true;
                }
            }
        }
        else {
            int kCopy = k;
            for (int i=0; i<kCopy; i++) {
                if (nums[i] < 0) {
                    nums[i] = -nums[i];
                    k--;
                }
                else if (nums[i] == 0) {
                    zeroExists = true;
                }
            }
        }
        if (k != 0) {
            if (zeroExists) {
                k = 0;
            }
            else if (k % 2 == 1) {
                Arrays.sort(nums);
                nums[0] = -nums[0];
                k = 0;
            }
        }
        // System.out.println("result: "+Arrays.toString(nums));
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}