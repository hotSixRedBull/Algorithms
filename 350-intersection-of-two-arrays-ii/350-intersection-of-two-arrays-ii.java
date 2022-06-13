class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] freq1 = new int[1001];
        for (int num : nums1) {
            freq1[num]++;
        }
        
        List<Integer> li = new ArrayList();
        for (int num : nums2) {
            if (freq1[num] > 0) {
                li.add(num);
                freq1[num]--;
            }
        }
        
        return li.stream().mapToInt(Integer::intValue).toArray();
    }
}