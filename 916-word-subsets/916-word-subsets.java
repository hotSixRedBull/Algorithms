class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList();
        HashMap<Character, Integer> maxMap = new HashMap();
        for (String word2 : words2) {
            Map<Character, Integer> map2 = buildMap(word2);
            for (char c : map2.keySet()) {
                if (maxMap.containsKey(c) == false) {
                    maxMap.put(c, map2.get(c));
                }
                else if(map2.get(c) > maxMap.get(c)){
                    maxMap.put(c, map2.get(c));
                }
            }
        }
        
        for (String word1 : words1) {
            Map<Character, Integer> map = buildMap(word1);
            boolean isUniversal = true;
            for (char c : maxMap.keySet()) {
                if (map.containsKey(c) == false
                   || map.get(c) < maxMap.get(c)) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                ans.add(word1);
            }
        }
        return ans;
    }
    
    public Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> map = new HashMap();
        for (int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        return map;
    }
}