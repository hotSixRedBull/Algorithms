class Solution {
    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        if (sentence1.length != sentence2.length) {
            return false;
        }
        
        Map<String, Set<String>> map = new HashMap();
        for (List<String> str : similarPairs) {
            String s1 = str.get(0);
            String s2 = str.get(1);
            map.putIfAbsent(s1, new HashSet());
            map.get(s1).add(s2);
            map.putIfAbsent(s2, new HashSet());
            map.get(s2).add(s1);
        }
        
        for (int i=0; i<sentence1.length; i++) {
            if (!sentence1[i].equals(sentence2[i])
               && ((map.containsKey(sentence1[i]) && !map.get(sentence1[i]).contains(sentence2[i]))
                  || !map.containsKey(sentence1[i]))) {
                return false;
            }
        }
        return true;
    }
}

/*
["great", "great", "good"]
["doubleplus","good", "good"]
[["great","doubleplus"]]
*/