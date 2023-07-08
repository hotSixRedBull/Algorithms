class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap();
        int start = 0;
        int max = Integer.MIN_VALUE;
        for (int end=0; end<s.length(); end++) {
            map.put(s.charAt(end), map.getOrDefault(s.charAt(end), 0)+1);
            while (map.keySet().size() > k && start < end) {
                if (map.get(s.charAt(start)) == 1) {
                    map.remove(s.charAt(start));
                }
                else {
                    map.put(s.charAt(start), map.get(s.charAt(start))-1);
                }
                start++;
            }
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}