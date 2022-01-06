class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int min = Math.min(word1.length(), word2.length());
        for (int i=0; i<min; i++) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }
        int max = Math.max(word1.length(), word2.length());
        if (word1.length() > word2.length()) {
            sb.append(word1.substring(min, max));
        }
        else if (word1.length() < word2.length()) {
            sb.append(word2.substring(min, max));
        }
        return sb.toString();
    }
}