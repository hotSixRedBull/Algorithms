class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
            if (word.length() == 1) {
                return true;
            }
            else if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                return word.equals(word.toUpperCase());
            }
            else {
                String substring =  word.substring(1, word.length());
                return substring.equals(substring.toLowerCase());
            }
        }
        else {
            return word.equals(word.toLowerCase());
        }
    }
}