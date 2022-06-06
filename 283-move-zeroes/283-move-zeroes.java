class Solution {
    public void moveZeroes(int[] nums) {
        int right = nums.length-1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            for (int j=i+1; j<nums.length; j++) {
                if (nums[j] != 0) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
        return;
    }
}