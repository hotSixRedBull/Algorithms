class Solution {
    public int[] anagramMappings(int[] nums1, int[] nums2) {
        HashMap<Integer, Set<Integer>> map = new HashMap();
        int i=0;
        for (int num2 : nums2) {
            if (!map.containsKey(num2)) {
                map.put(num2, new HashSet());
            }
            map.get(num2).add(i++);
        }
        
        int[] ans = new int[nums1.length];
        for (i=0; i<nums1.length; i++) {
            Set<Integer> set = map.get(nums1[i]);
            for (int num : set) {
                ans[i] = num;
                map.get(nums1[i]).remove(num);
                break;
            }
        }
        return ans;
    }
}