class Solution {
    public int arraySign(int[] nums) {
        int result = 1;
        for (int num : nums) {
            if (num < 0) {
                result *= -1;
            }
            else if (num == 0) {
                return 0;
            }
        }
        return result;
    }
}