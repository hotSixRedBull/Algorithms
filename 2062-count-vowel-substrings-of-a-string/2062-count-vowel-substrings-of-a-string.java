class Solution {
    public int countVowelSubstrings(String word) {
        HashMap<Character, Integer> vowelCntMap = new HashMap<>();
        int cnt = 0;
        int first = 0;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                vowelCntMap.clear();
                first = i+1;
            }
            else {
                vowelCntMap.put(word.charAt(i), vowelCntMap.getOrDefault(c, 0)+1);
                if (i-first >= 4) {
                    if (isVowelString(vowelCntMap)) {
                        cnt++;
                    }
                    HashMap<Character, Integer> tmpMap = new HashMap<>(vowelCntMap);
                    for (int j=first; j<=i; j++) {
                        tmpMap.put(word.charAt(j), tmpMap.getOrDefault(word.charAt(j), 0)-1);
                        if (isVowelString(tmpMap)) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }
    public boolean isVowelString(HashMap<Character, Integer> map) {
        return map.getOrDefault('a', 0) > 0 && map.getOrDefault('e', 0) > 0 && map.getOrDefault('i', 0) > 0 && map.getOrDefault('o', 0) > 0 && map.getOrDefault('u', 0) > 0;
    }
}