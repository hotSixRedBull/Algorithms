class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sStk = new Stack();
        Stack<Character> tStk = new Stack();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (sStk.size() > 0) {
                    sStk.pop();
                }
            }
            else {
                sStk.push(c);
            }
        }
        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (tStk.size() > 0) {
                    tStk.pop();
                }
            }
            else {
                tStk.push(c);
            }
        }
        if (sStk.size() != tStk.size()) {
            return false;
        }
        while (sStk.size() > 0) {
            if (sStk.pop() != tStk.pop()) {
                return false;
            } 
        }
        return true;
    }
}