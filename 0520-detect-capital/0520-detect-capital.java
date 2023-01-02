class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }
        if (word.charAt(0) >= 97
           || word.charAt(1) >= 97) {
            for (int i=1; i<word.length(); i++) {
                if (word.charAt(i) < 97) {
                    return false;
                }
            }
        }
        else {
            for (int i=1; i<word.length(); i++) {
                if (word.charAt(i) >= 97) {
                    return false;
                }
            }
        }
        return true;
    }
}