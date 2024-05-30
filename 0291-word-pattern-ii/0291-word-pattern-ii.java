//saw solution
class Solution {
    public boolean wordPatternMatch(String pattern, String s) {
        Map<Character, String> symbolMap = new HashMap<>();
        Set<String> wordSet = new HashSet<>();

        return isMatch(s, 0, pattern, 0, symbolMap, wordSet);
    }

    private boolean isMatch(String s, int sIndex, String pattern, int pIndex, Map<Character, String> symbolMap,
            Set<String> wordSet) {
        // Base case: reached end of pattern
        if (pIndex == pattern.length()) {
            return sIndex == s.length(); // True iff also reached end of s
        }

        // Get current pattern character
        char symbol = pattern.charAt(pIndex);

        // This symbol already has an associated word
        if (symbolMap.containsKey(symbol)) {
            String word = symbolMap.get(symbol);
            // Check if we can use it to match s[sIndex...sIndex + word.length()]
            if (!s.startsWith(word, sIndex)) {
                return false;
            }
            // If it matches continue to match the rest
            return isMatch(s, sIndex + word.length(), pattern, pIndex + 1, symbolMap, wordSet);
        }

        // This symbol does not exist in the map
        for (int k = sIndex + 1; k <= s.length(); k++) {
            String newWord = s.substring(sIndex, k);
            if (wordSet.contains(newWord)) {
                continue;
            }
            // Create or update it
            symbolMap.put(symbol, newWord);
            wordSet.add(newWord);
            // Continue to match the rest
            if (isMatch(s, k, pattern, pIndex + 1, symbolMap, wordSet)) {
                return true;
            }
            // Backtracking
            symbolMap.remove(symbol);
            wordSet.remove(newWord);
        }
        // No mappings were valid
        return false;
    }
}