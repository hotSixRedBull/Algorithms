class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        
        HashMap<String, Set<String>> similarMap = new HashMap<>();
        for (List<String> similarPair : similarPairs) {
            if (!similarMap.containsKey(similarPair.get(0))) {
                similarMap.put(similarPair.get(0), new HashSet<>());
            }
            similarMap.get(similarPair.get(0)).add(similarPair.get(1));
            if (!similarMap.containsKey(similarPair.get(1))) {
                similarMap.put(similarPair.get(1), new HashSet<>());
            }
            similarMap.get(similarPair.get(1)).add(similarPair.get(0));
        }
        
        for (int i=0; i<sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i]) && (!similarMap.containsKey(sentence1[i]) || (similarMap.containsKey(sentence1[i]) && !similarMap.get(sentence1[i]).contains(sentence2[i])))) {
                return false;
            }
        }
        return true;
    }
}