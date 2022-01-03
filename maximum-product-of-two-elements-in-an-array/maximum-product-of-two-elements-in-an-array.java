class Solution {
    public int maxProduct(int[] nums) {
        int max = -1;
        int max2 = -1;
        for (int num : nums) {
            if(max <= num) {
                max2 = max;
                max = num;
            }
            else if (max2 < num) {
                max2 = num;
            }
        }
        return (max-1)*(max2-1);
    }
}