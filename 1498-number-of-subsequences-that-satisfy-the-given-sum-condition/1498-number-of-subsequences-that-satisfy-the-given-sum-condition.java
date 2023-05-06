class Solution {
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        int mod = 1_000_000_007;
        int[] power = new int[n];
        power[0] = 1;
        for (int i=1; i<n; i++) {
            power[i] = (power[i-1]*2)%mod;
        }
        
        int answer = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++) {
            int right = rightMost(nums, target - nums[i]);
            if (nums[right] + nums[i] > target) {
                continue;
            }
            if (right >= i) {
                answer += power[right - i];
                answer %= mod;
            }
        }
        return answer;
    }
    public int rightMost(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while (lo < hi) {
            int mid = (lo + hi + 1)/2;
            if (nums[mid] <= target) {
                lo = mid;
            }
            else {
                hi = mid-1;
            }
        }
        return lo;
    }
}