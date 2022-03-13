class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stk = new Stack();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stk.push(c);
            }
            else {
                if (stk.size() == 0) {
                    return false;
                }
                
                char top = stk.peek();
                if (map.get(c) == top) {
                    stk.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stk.size() == 0;
    }
}