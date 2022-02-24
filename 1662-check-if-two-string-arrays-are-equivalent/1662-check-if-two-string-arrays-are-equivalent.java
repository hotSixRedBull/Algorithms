class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String wordString1 = String.join("",word1);
        String wordString2 = String.join("",word2);
        return wordString1.equals(wordString2);
    }
}