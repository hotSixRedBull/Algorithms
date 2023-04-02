class Solution {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int lastW1 = -1;
        int lastW2 = -1;
        int result = Integer.MAX_VALUE;
        for (int i=0; i<wordsDict.length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                if (word1.equals(word2)) {
                    if (lastW1 != -1) {
                        result = Math.min(result, i-lastW1);
                    }
                    lastW1 = i;
                }
                else {
                    lastW1 = i;
                    if (lastW2 != -1) {
                        result = Math.min(result, lastW1-lastW2);
                    }
                }
            }
            else if (word.equals(word2)) {
                lastW2 = i;
                if (lastW1 != -1) {
                    result = Math.min(result, lastW2-lastW1);
                }
            }
        }
        return result;
    }
}