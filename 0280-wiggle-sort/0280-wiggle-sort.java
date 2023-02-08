class Solution {
    public void wiggleSort(int[] nums) {
        int[] sort = new int[nums.length];
        int index = 0;
        for (int num : nums) {
            sort[index++] = num;
        }
        Arrays.sort(sort);
        int lo = 0;
        int hi = nums.length-1;
        for (int i=0; i<nums.length; i++) {
            nums[i] = i % 2 == 0 ? sort[lo++] : sort[hi--];
        }
        return;
    }
}