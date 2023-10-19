class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk1 = new Stack();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#') {
                if (stk1.size() > 0) {
                    stk1.pop();
                }
            }
            else {
                stk1.push(c);
            }
        }
        Stack<Character> stk2 = new Stack();
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            if (c == '#') {
                if (stk2.size() > 0) {
                    stk2.pop();
                }
            }
            else {
                stk2.push(c);
            }
        }
        if (stk1.size() != stk2.size()) {
            return false;
        }
        while (stk1.size() > 0) {
            if (stk1.pop() != stk2.pop()) {
                return false;
            }
        }
        return true;
    }
}