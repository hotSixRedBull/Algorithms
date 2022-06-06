class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap();
        HashMap<Integer, Integer> map2 = new HashMap();
        for (int num : nums1) {
            map1.put(num, map1.getOrDefault(num, 0)+1);
        }
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0)+1);
        }
        Set<Integer> set1 = map1.keySet();
        set1.retainAll(map2.keySet());
        List<Integer> li = new ArrayList();
        for (int num : set1) {
            int cnt = Math.min(map1.get(num), map2.get(num));
            for (int i=0; i<cnt; i++) {
                li.add(num);
            }
        }
        int[] result = new int[li.size()];
        for (int i=0; i<li.size(); i++) {
            result[i] = li.get(i);
        }
        return result;
    }
}