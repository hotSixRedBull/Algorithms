class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0;
        HashMap<Integer, Integer>[] maps = new HashMap[2];
        for (int i=0; i<2; i++) {
            maps[i] = new HashMap();
        }
        for (int num : nums1) {
            for (int num2 : nums2) {
                maps[0].put(num+num2, maps[0].getOrDefault(num+num2, 0)+1);
            }
        }
        for (int num : nums3) {
            for (int num2 : nums4) {
                maps[1].put(num+num2, maps[1].getOrDefault(num+num2, 0)+1);
            }
        }
        for (int target : maps[0].keySet()) {
            if (maps[1].containsKey(-target)) {
                cnt += maps[0].get(target)*maps[1].get(-target);
            }
        }
        return cnt;
    }
}
/* insight
- Sort
  - HashMap and use index
    - If index is 
- 
*/