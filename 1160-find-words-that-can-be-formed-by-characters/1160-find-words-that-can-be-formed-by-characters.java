class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> criteria = new HashMap();
        for (char c : chars.toCharArray()) {
            criteria.put(c, criteria.getOrDefault(c, 0)+1);
        }
        
        int result = 0;
        for (String word : words) {
            if (word.length() > chars.length()) {
                continue;
            }
            
            Map<Character, Integer> target = new HashMap();
            for (char c : word.toCharArray()) {
                target.put(c, target.getOrDefault(c, 0)+1);
            }
            
            if (criteria.keySet().containsAll(target.keySet()) == false) {
                continue;
            }
            
            boolean isValid = true;
            for (char c : target.keySet()) {
                if (criteria.containsKey(c) == false
                   || criteria.get(c) < target.get(c)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                result += word.length();
            }
        }
        return result;
    }
}