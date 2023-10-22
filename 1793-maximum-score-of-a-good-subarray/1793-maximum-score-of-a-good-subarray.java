class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int maxValue = nums[k];
        int maxCost = nums[k];
        int lo = k-1;
        int hi = k+1;
        while (lo >= 0 || hi <= n) {
            // System.out.println(String.format("lo: %d, hi: %d", lo, hi));
            int i = lo + 1;
            int j = hi - 1;
            maxCost = Math.max(maxCost, maxValue * (j-i+1));
            if (lo >= 0 && nums[lo] >= maxValue) {
                lo--;
            }
            else if (hi < n && nums[hi] >= maxValue) {
                hi++;
            }
            else {
                if (lo >= 0 && hi < n) {
                    if (nums[lo] <= nums[hi]) {
                        maxValue = nums[hi];
                    }
                    else {
                        maxValue = nums[lo];
                    }
                }
                else if (lo >= 0) {
                    maxValue = nums[lo];
                }
                else if (hi < n) {
                    maxValue = nums[hi];
                }
                else {
                    break;
                }
            }
        }
        return maxCost;
    }
}