class Solution {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> cnt = getCnt(words[0]);
        for (int i=1; i<words.length; i++) {
            cnt = merge(cnt, getCnt(words[i]));
        }
        List<String> ans = new ArrayList();
        for (char key : cnt.keySet()) {
            for (int i=0; i<cnt.get(key); i++) {
                ans.add(""+key);
            }
        }
        return ans;
    }
    
    public Map<Character, Integer> getCnt(String s) {
        Map<Character, Integer> cnt = new HashMap();
        for (int i=0; i<s.length(); i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0)+1);
        }
        return cnt;
    }
    
    public Map<Character, Integer> merge(Map<Character, Integer> main, Map<Character, Integer> sub) {
        Set<Character> keys = new HashSet(main.keySet());
        for (char key : keys) {
            if (sub.containsKey(key)) {
                main.put(key, Math.min(main.get(key), sub.get(key)));
            }
            else {
                main.remove(key);
            }
        }
        return main;
    }
}