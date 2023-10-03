class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int result = 0;
        for (int key : map.keySet()) {
            int count = map.get(key);
            if (count > 1) {
                result += count*(count-1)/2;
            }
        }
        return result;
    }
}