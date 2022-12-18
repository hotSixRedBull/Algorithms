class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stk = new Stack();
        for (int i= n-1; i>=0; i--) {
            while (stk.size() > 0
                  && temperatures[stk.peek()] <= temperatures[i]) {
                stk.pop();
            }
            if (stk.size() > 0) {
                ans[i] = stk.peek()-i;
            }
            stk.push(i);
        }
        return ans;
    }
}

/*
same value
[89,62,70,58,47,47,46,76,100,70]
*/