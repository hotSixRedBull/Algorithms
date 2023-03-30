class Solution {
    Map<String, Boolean> cache;
    public Solution() {
        cache = new HashMap();
    }
    public boolean isScramble(String s1, String s2) {
        String key = String.format("%s, %s", s1, s2);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        // System.out.println(key);
        int n = s1.length();
        if (n == 1) {
            cache.put(key, s1.charAt(0) == s2.charAt(0));
            return s1.charAt(0) == s2.charAt(0);
        }
        
        for (int i=1; i<n; i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
               && isScramble(s1.substring(i,n), s2.substring(i,n))) {
                cache.put(key, true);
                return true;
            }
            if (isScramble(s1.substring(0,i), s2.substring(n-i,n))
               && isScramble(s1.substring(i,n), s2.substring(0, n-i))) {
                cache.put(key, true);
                return true;
            }
        }
        cache.put(key, false);
        return false;
    }
}