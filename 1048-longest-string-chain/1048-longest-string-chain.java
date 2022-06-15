class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> cache = new HashMap();
        Set<String> set = new HashSet();
        int ans = 0;
        for (String word : words) {
            set.add(word);
        }
        for (String word : words) {
            ans = Math.max(ans, dp(word, cache, set));
        }
        // System.out.println(cache);
        return ans;
    }
    public int dp(String s, Map<String, Integer> cache, Set<String> set) {
        if (set.contains(s) == false) {
            return -1;
        }
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        if (s.length() == 1) {
            return 1;
        }
        int max = 0;
        max = Math.max(max, dp(s.substring(1, s.length()), cache, set));
        for (int i=1; i<s.length()-1; i++) {
            max = Math.max(max, dp(s.substring(0,i)+s.substring(i+1,s.length()), cache, set));
        }
        max = Math.max(max, dp(s.substring(0, s.length()-1), cache, set));
        cache.put(s, max+1);
        return max+1;
    }
}