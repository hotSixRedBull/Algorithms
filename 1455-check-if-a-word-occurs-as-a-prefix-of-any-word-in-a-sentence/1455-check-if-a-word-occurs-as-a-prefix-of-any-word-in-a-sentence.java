class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] strs = sentence.split(" ");
        for (int i=0; i<strs.length; i++) {
            if (strs[i].startsWith(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }
}