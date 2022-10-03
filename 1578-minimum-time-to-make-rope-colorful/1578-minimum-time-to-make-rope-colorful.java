class Solution {
    public int minCost(String colors, int[] neededTime) {
        Stack<Integer> stk = new Stack();
        int sum = 0;
        stk.add(neededTime[0]);
        for (int i=1; i<colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i-1)) {
                if (neededTime[i] > stk.peek()) {
                    sum += stk.pop();
                    stk.add(neededTime[i]);
                }
                else {
                    sum += neededTime[i];
                }
            }
            else {
                stk.add(neededTime[i]);
            }
            // System.out.println(stk);
        }
        return sum;
    }
}