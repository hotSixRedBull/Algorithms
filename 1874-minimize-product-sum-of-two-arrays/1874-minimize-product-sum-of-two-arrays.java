class Solution {
    public int minProductSum(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int sum = 0;
        for (int i=0; i<nums1.length; i++) {
            sum += nums1[i]*nums2[nums1.length-1-i];
        }
        return sum;
    }
}