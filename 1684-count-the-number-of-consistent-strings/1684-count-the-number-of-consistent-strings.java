class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet();
        for (int i=0; i<allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }
        int cnt = 0;
        for (String w : words) {
            boolean isConsistent = true;
            for (int i=0; i<w.length(); i++) {
                if (set.contains(w.charAt(i)) == false) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                cnt++;
            }
        }
        return cnt;
    }
}