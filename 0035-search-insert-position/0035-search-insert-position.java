class Solution {
    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        if (pos < 0) {
            pos++;
            pos *= -1;
        }
        return pos;
    }
}