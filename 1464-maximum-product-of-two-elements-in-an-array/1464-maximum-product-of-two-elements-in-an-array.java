class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = nums[n-1];
        int max2 = nums[n-2];
        return (max-1)*(max2-1);
    }
}