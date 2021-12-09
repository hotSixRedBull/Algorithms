class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int i=1; i<s.length(); i++) {
            if (s.length()%i != 0) {
                continue;
            }
            //System.out.println(String.format("%s is repeated %d.", s.substring(0, i), s.length()/i));
            if(s.substring(0, i).repeat(s.length()/i).equals(s)) {
                return true;
            }
        }
        return false;
    }
}