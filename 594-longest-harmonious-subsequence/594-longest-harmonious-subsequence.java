class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        int ans = 0;
        List<Integer> key = new ArrayList(freq.keySet());
        Collections.sort(key);
        for (int k : key) {
            if (!freq.containsKey(k+1)) {
                continue;
            }
            int len = freq.get(k)+freq.get(k+1);
            ans = Math.max(ans, len);
        }
        return ans;
    }
}