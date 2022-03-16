class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack();
        int pi = 0;
        for (int i=0; i<pushed.length; i++) {
            if (popped[pi] == pushed[i]) {
                pi++;
                continue;
            }
            else if (stk.size() > 0
                     && popped[pi] == stk.peek()) {
                while (stk.size() > 0
                     && popped[pi] == stk.peek()) {
                    stk.pop();
                    pi++;
                }
            }
            stk.push(pushed[i]);
            // System.out.println(String.format("%dth round, stk: %s, pi: %d", i, stk, pi));
        }
        while (pi < popped.length) {
            if (stk.size() > 0
                     && popped[pi] == stk.peek()) {
                stk.pop();
                pi++;
            }
            else {
                return false;
            }
        }
        return stk.size() == 0 && pi == popped.length;
    }
}

/*
[2,3,0,1]
[0,3,2,1]
[1,2,0]
[2,1,0]
*/