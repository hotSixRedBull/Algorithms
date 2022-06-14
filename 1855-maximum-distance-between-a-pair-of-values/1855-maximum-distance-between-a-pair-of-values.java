class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        for (int i=0; i<nums1.length; i++) {
            //binary search for the rightmost && bigger than nums1[i]
            int lo = i;
            int hi = nums2.length-1;
            while (lo < hi) {
                int mid = lo - (lo - hi)/2;
                if (nums2[mid] >= nums1[i]) {
                    lo = mid+1;
                }
                else {
                    hi = mid;
                }
            }
            // answer is end of index
            if (lo < nums2.length
               && nums1[i] <= nums2[lo]) {
                max = Math.max(max, lo - i);
            }
            // answer is lo-1
            else if (lo > 0
               && lo-1 < nums2.length
               && nums1[i] <= nums2[lo-1]) {
                max = Math.max(max, lo -1 - i);
            }
        }
        return max;
    }
}