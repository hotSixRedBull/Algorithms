class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> cnt = new HashMap();
        int longest = 0;
        int start = 0;
        int n = s.length();
        for (int i=0; i<n; i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0)+1);
            if (cnt.size() <= 2) {
                longest = Math.max(longest, i-start+1);
            }
            else if(cnt.size() > 2) {
                while (cnt.size() != 2) {
                    if (cnt.get(s.charAt(start)) == 1) {
                        cnt.remove(s.charAt(start));
                    }
                    else {
                        cnt.put(s.charAt(start), cnt.get(s.charAt(start))-1);
                    }
                    start++;
                }
            }
        }
        return longest;
    }
}