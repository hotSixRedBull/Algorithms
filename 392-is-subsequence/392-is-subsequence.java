class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int i=0, j=0;
        for (;j<t.length();j++) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                if (i >= s.length()) {
                    break;
                }
            }
        }
        return i == s.length();
    }
}