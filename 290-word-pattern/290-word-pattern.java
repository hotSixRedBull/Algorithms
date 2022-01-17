class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> hashMap = new HashMap<>();
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        for (int i=0; i<pattern.length(); i++) {
            char cur = pattern.charAt(i);
            if (hashMap.containsKey(cur)) {
                String word = hashMap.get(cur);
                if (!word.equals(words[i])) {
                    return false;
                }
            }
            else {
                if (hashMap.containsValue(words[i])) {
                    return false;
                }
                hashMap.put(pattern.charAt(i), words[i]);
            }
        }
        return true;
    }
}