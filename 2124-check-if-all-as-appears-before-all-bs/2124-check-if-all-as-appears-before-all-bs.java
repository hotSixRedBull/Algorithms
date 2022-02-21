class Solution {
    public boolean checkString(String s) {
        boolean isB = false;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == 'b') {
                isB = true;
            }
            else if (isB && s.charAt(i) == 'a') {
                return false;
            }
        }
        return true;
    }
}