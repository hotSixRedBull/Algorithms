class Solution {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            min[i] = Math.min(nums[i], min[i-1]);
        }
        
        Stack<Integer> stk = new Stack();
        for (int i=nums.length-1; i>=0; i--) {
            while (!stk.isEmpty()
                  && stk.peek() <= min[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()
               && nums[i] > stk.peek()
               && stk.peek() > min[i]) {
                return true;
            }
            stk.add(nums[i]);
        }
        return false;
    }
}