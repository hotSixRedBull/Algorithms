class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap();
        HashMap<Character, Integer> cntMap = new HashMap();
        for (int i=0; i<s1.length(); i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
        }
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        for (int i=0; i<s1.length(); i++) {
            cntMap.put(s2.charAt(i), cntMap.getOrDefault(s2.charAt(i), 0)+1);
        }
        if (isPermutation(map, cntMap)) {
            return true;
        }
        for (int i=s1.length(); i<s2.length(); i++) {
            cntMap.put(s2.charAt(i-s1.length()), cntMap.getOrDefault(s2.charAt(i-s1.length()), 0)-1);
            if (cntMap.get(s2.charAt(i-s1.length())) == 0) {
                cntMap.remove(s2.charAt(i-s1.length()));
            }
            cntMap.put(s2.charAt(i), cntMap.getOrDefault(s2.charAt(i), 0)+1);
            if (isPermutation(map, cntMap)) {
                return true;
            }
        }
        return false;
    }
    public boolean isPermutation(HashMap<Character, Integer> pattern, HashMap<Character, Integer> cnt) {
        for (char key : pattern.keySet()) {
            if (pattern.get(key).intValue() != cnt.getOrDefault(key, -1).intValue()) {
                return false;
            }
        }
        return true;
    }
}

/*
"ab"
"a"
"abcdxabcde"
"abcdeabcdx"
*/