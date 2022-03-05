class Solution {
    private HashMap<Integer, Integer> map;
    private HashMap<Integer, Integer> cache;
    public int deleteAndEarn(int[] nums) {
        map = new HashMap();
        cache = new HashMap();
        
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+num);
            max = Math.max(max, num);
        }
        
        return maxScore(max);
    }
    public int maxScore(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return map.getOrDefault(1, 0);
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        
        int result = map.getOrDefault(n, 0);
        cache.put(n, Math.max(maxScore(n-1), maxScore(n-2)+result));
        return cache.get(n);
    }
}