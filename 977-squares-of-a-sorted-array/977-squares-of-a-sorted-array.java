class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int p1 = 0;
        int p2 = nums.length-1;
        int p3 = nums.length-1;
        while (p1 <= p2
              && p3 >= 0) {
            if (Math.abs(nums[p1]) > Math.abs(nums[p2])) {
                result[p3--] = nums[p1]*nums[p1++];
            }
            else {
                result[p3--] = nums[p2]*nums[p2--];
            }
        }
        return result;
    }
}