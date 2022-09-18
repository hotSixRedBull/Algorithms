class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> set = new HashSet();
        int[] cnt = new int[256];
        int start = 0;
        int len = 0;
        for (int i=0; i<s.length(); i++) {
            // System.out.println(String.format("cnt[s.charAt(i)-'a']: %d", cnt[s.charAt(i)-'a']));
            int indexToAdd = s.charAt(i)-'A';
            if (cnt[indexToAdd] == 0) {
                set.add(s.charAt(i));
            }
            cnt[indexToAdd]++;
            while (set.size() > 2) {
                // System.out.println(Arrays.toString(Arrays.copyOfRange(s.toCharArray(),start,i+1)));
                // System.out.println(Arrays.toString(cnt));
                int indexToRemove = s.charAt(start)-'A';
                start++;
                cnt[indexToRemove]--;
                if (cnt[indexToRemove] == 0) {
                    set.remove(s.charAt(start-1));
                }
                // System.out.println(Arrays.toString(cnt));
            }
            len = Math.max(len, i-start+1);
        }
        return len;
    }
}

/*
"abcabcabc"
"ababcbcbaaabbdef"
"abZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX"

"abcabcabc" -> bugfix, removing wrong character so result was larger than the answer.
"ababcbcbaaabbdef" -> bugfix, removing wrong character, made out of index error.
"abZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZZYX" -> read problem more carefully.. T.T
*/