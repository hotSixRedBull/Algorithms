class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack();
        for (String t : tokens) {
            if (t.equals("+")) {
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a+b);
            }
            else if (t.equals("-")) {
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a-b);   
            }
            else if (t.equals("*")) {
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a*b);
            }
            else if (t.equals("/")) {
                int b = stk.pop();
                int a = stk.pop();
                stk.push(a/b);
            }
            else {
                stk.push(Integer.parseInt(t, 10));
            }
        }
        return stk.peek();
    }
}