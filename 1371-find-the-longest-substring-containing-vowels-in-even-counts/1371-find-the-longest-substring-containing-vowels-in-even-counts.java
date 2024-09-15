//wrong answer
class Solution {

    public int findTheLongestSubstring(String s) {
        int prefixXOR = 0;
        int[] characterMap = new int[26];
        characterMap['a' - 'a'] = 1;
        characterMap['e' - 'a'] = 2;
        characterMap['i' - 'a'] = 4;
        characterMap['o' - 'a'] = 8;
        characterMap['u' - 'a'] = 16;
        int[] mp = new int[32];
        for (int i = 0; i < 32; i++) mp[i] = -1;
        int longestSubstring = 0;
        for (int i = 0; i < s.length(); i++) {
            prefixXOR ^= characterMap[s.charAt(i) - 'a'];
            if (mp[prefixXOR] == -1 && prefixXOR != 0) mp[prefixXOR] = i;
            longestSubstring = Math.max(longestSubstring, i - mp[prefixXOR]);
        }
        return longestSubstring;
    }
}
/*
class Solution {
    public int findTheLongestSubstring(String s) {
        int max = 0;
        int lo = 0;
        int hi = s.length();
        while (lo <= hi) {
            int len = hi - (hi-lo)/2;
            // System.out.println(String.format("%d length is ", len));
            if (isPossible(s, len)) {
                // System.out.println(String.format(">>> o"));
                lo = len+1;
                max = Math.max(max, len);
            }
            else {
                // System.out.println(String.format(">>> x"));
                hi = len-1;
            }
        }
        return max;
    }
    
    public boolean isPossible(String s, int len) {
        Map<Character, Integer> map = new HashMap();
        map.put('a', 0);
        map.put('e', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('u', 0);
        
        for (int i=0; i<len; i++) {
            char cur = s.charAt(i);
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur)+1);
            }
        }
        if (isEven(map)) {
            return true;
        }
        for (int i=len; i<s.length(); i++) {
            char cur = s.charAt(i);
            char prev = s.charAt(i-len);
            if (map.containsKey(prev)) {
                map.put(prev, map.get(prev)-1);
            }
            if (map.containsKey(cur)) {
                map.put(cur, map.get(cur)+1);
            }
            if (isEven(map)) {
                return true;
            }
            else {
                if (len == 12) {
                    System.out.println(String.format("%s is false, map: %s", s.substring(i-len+1, i+1), map));
                }
            }
        }
        return false;
    }
    
    public boolean isEven(Map<Character, Integer> map) {
        for (char key : map.keySet()) {
            if (map.get(key) % 2 == 1) {
                return false;
            }
        }
        return true;
    }
}
*/