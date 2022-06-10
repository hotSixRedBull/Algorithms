class Solution {
    public int specialArray(int[] nums) {
        int search = 0;
        Arrays.sort(nums);
        for (int i=0; i<nums.length;i++) {
            while (nums[i] >= search) {
                if (nums.length-i == search) {
                    return search;
                }
                search++;
            }
        }
        return -1;
    }
}