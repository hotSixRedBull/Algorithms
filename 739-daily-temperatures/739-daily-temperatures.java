class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack();
        int[] ans = new int[temperatures.length];
        for (int i=0; i<temperatures.length; i++) {
            if (!stk.empty()) {
                while (stk.size() > 0 && temperatures[stk.peek()] < temperatures[i]) {
                    int target = stk.pop();
                    ans[target] = i-target;
                }
            }
            stk.add(i);
        }
        return ans;
    }
}