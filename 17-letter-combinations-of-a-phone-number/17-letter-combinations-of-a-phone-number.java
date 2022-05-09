class Solution {
    static HashMap<Character, List<Character>> map;
    static List<String> ans;
    public List<String> letterCombinations(String digits) {
        map = new HashMap();
        map.put('2', List.of('a','b','c'));
        map.put('3', List.of('d','e','f'));
        map.put('4', List.of('g','h','i'));
        map.put('5', List.of('j','k','l'));
        map.put('6', List.of('m','n','o'));
        map.put('7', List.of('p','q','r','s'));
        map.put('8', List.of('t','u','v'));
        map.put('9', List.of('w','x','y','z'));
        map.put('0', List.of(' '));
        map.put('#', List.of('+'));
        ans = new ArrayList();
        backtrack(0, false, digits, "");
        return ans;
    }
    public void backtrack(int cur, boolean isCapital, String digits, String built) {
        // System.out.println("built: "+built);
        if (cur == digits.length()) {
            if (built.length() != 0) {
                ans.add(built);
            }
            return;
        }
        if (digits.charAt(cur) == '#') {
            backtrack(cur+1, true, digits, built);
        }
        List<Character> nei = map.get(digits.charAt(cur));
        for (char n : nei) {
            if (isCapital) {
                int pos = n-'a';
                char cap = (char)(pos+'A');
                backtrack(cur+1, false, digits, built+cap);
            }
            else {
                backtrack(cur+1, false, digits, built+n);
            }
        }
    }
}