class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap();
        int cnt = 0;
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(k-nums[i])) {
                cnt++;
                int key = k-nums[i];
                if (map.get(key) == 1) {
                    map.remove(key);
                }
                else {
                    map.put(key, map.get(key)-1);
                }
            }
            else {
                map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            }
        }
        return cnt;
    }
}