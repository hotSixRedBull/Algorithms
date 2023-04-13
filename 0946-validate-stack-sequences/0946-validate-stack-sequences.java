class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int n =pushed.length;
        Stack<Integer> stk = new Stack();
        int j=0;
        for (int i=0; i<n; i++) {
            stk.push(pushed[i]);
            while (stk.size() > 0
               && stk.peek() == popped[j]) {
                stk.pop();
                j++;
            }
        }
        return stk.size() == 0 && j == n;
    }
}