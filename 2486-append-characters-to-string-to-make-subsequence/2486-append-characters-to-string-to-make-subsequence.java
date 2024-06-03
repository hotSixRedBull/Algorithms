class Solution {
    public int appendCharacters(String s, String t) {
        int ti=0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == t.charAt(ti)) {
                ti++;
                if (ti >= t.length()) {
                    break;
                }
            }
        }
        return t.length()-ti;
    }
}