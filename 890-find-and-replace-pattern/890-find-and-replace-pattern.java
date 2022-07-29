class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> output = new ArrayList();
        for (String word : words) {
            boolean isReplacable = true;
            boolean[] isUsed = new boolean[26];
            Map<Character, Character> mappingTable = new HashMap();
            for (int i=0; i<word.length(); i++) {
                if (mappingTable.containsKey(word.charAt(i))) {
                    if (mappingTable.get(word.charAt(i)) != pattern.charAt(i)) {
                        isReplacable = false;
                        break;
                    }
                    else {
                        continue;
                    }
                }
                else {
                    if (isUsed[pattern.charAt(i) - 'a'] == false) {
                        mappingTable.put(word.charAt(i), pattern.charAt(i));
                        isUsed[pattern.charAt(i) - 'a'] = true;
                    }
                    else {
                        isReplacable = false;
                        break;
                    }
                }
            }
            if (isReplacable) {
                output.add(word);
            }
        }
        return output;
    }
}