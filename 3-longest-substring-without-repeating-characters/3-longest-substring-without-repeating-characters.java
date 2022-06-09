class Solution {
    public int lengthOfLongestSubstring(String s) {
        //two pointer from the biginning
        int max = 0;
        for (int left=0; left<s.length(); left++) {
            Set<Character> set = new HashSet();
            int len = 1;
            set.add(s.charAt(left));
            for (int right=left+1; right<s.length(); right++) {
                if (set.contains(s.charAt(right))) {
                    break;
                }
                set.add(s.charAt(right));
                len++;
            }
            max = Math.max(max, len);
        }
        return max;
    }
}