class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap();
        int len = 0;
        int start = 0;
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            int highest = map.lastKey();
            int lowest = map.firstKey();
            // System.out.println(String.format("start: %d, i: %d, hi: %d, lo: %d", start, i, highest, lowest));
            while (highest-lowest > limit) {
                // System.out.println(String.format("hi-lo: %d, limit: %d", highest-lowest, limit));
                if (map.get(nums[start]) == 1) {
                    map.remove(nums[start]);
                }
                else {
                    map.put(nums[start], map.getOrDefault(nums[start], 0)-1);
                }
                highest = map.lastKey();
                lowest = map.firstKey();
                start++;
                // System.out.println(String.format("new >> start: %d, i: %d, hi: %d, lo: %d", start, i, highest, lowest));
            }
            len = Math.max(len, i-start+1);
        }
        return len;
    }
}