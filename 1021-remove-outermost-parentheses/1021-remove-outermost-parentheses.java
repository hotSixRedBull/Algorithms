class Solution {
    public String removeOuterParentheses(String s) {
        int min = Integer.MAX_VALUE;
        int cur = 0;
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                cur++;
                Set<Integer> set = map.getOrDefault(cur, new HashSet<>());
                set.add(i);
                map.put(cur, set);
                min = Math.min(min, cur);
            }
            else {
                Set<Integer> set = map.getOrDefault(cur, new HashSet<>());
                set.add(i);
                map.put(cur, set);
                cur--;
            }
        }
        
        String ans = "";
        Set<Integer> minSet = map.get(min);
        for (int i=0; i<s.length(); i++) {
            if (!minSet.contains(i)) {
                ans += s.charAt(i);
            }
        }
        return ans;
    }
}