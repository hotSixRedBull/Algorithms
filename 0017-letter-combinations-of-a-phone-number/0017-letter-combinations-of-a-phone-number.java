class Solution {
    List<String> results;
    Map<Character, List<Character>> map;
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList();
        }
        map = new HashMap();
        map.put('2', new ArrayList(List.of('a','b','c')));
        map.put('3', new ArrayList(List.of('d','e','f')));
        map.put('4', new ArrayList(List.of('g','h','i')));
        map.put('5', new ArrayList(List.of('j','k','l')));
        map.put('6', new ArrayList(List.of('m','n','o')));
        map.put('7', new ArrayList(List.of('p','q','r','s')));
        map.put('8', new ArrayList(List.of('t','u','v')));
        map.put('9', new ArrayList(List.of('w','x','y','z')));
        
        results = new ArrayList();
        c(digits, "");
        return results;
    }
    public void c(String digits, String built) {
        if (digits.length() == 0) {
            results.add(built);
            return;
        }
        List<Character> li = map.get(digits.charAt(0));
        for (char c : li) {
            c(digits.substring(1), built+c);
        }
    }
}