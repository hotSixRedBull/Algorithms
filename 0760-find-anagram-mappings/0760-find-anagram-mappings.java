class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap();
        for (int i=0; i<n; i++) {
            map.putIfAbsent(nums2[i], new PriorityQueue());
            map.get(nums2[i]).add(i);
        }
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            result[i] = map.get(nums1[i]).poll();
        }
        return result;
    }
}