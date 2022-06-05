class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i=0; i<m; i++) {
            pq.add(nums1[i]);
        }
        for (int num : nums2) {
            pq.add(num);
        }
        for (int i=0; i<nums1.length; i++) {
            nums1[i] = pq.poll();
        }
        return;
    }
}