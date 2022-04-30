class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;
        int i=0;
        int j=0;
        HashMap<Character, Integer> freq = new HashMap();
        while (i < s.length() && j < s.length()) {
            freq.put(s.charAt(j), freq.getOrDefault(s.charAt(j), 0)+1);
            if (freq.keySet().size() <= 2) {
                max = Math.max(max, j-i+1);
            }
            else {
                while (i < s.length()
                       && freq.keySet().size() > 2) {
                    if (freq.get(s.charAt(i)) == 1) {
                        freq.remove(s.charAt(i));
                    }
                    else {
                        freq.put(s.charAt(i), freq.get(s.charAt(i))-1);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}