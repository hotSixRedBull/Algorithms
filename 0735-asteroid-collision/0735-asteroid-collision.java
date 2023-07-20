class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> stk = new Stack();
        for (int i=0; i<n; i++) {
            if (stk.size() == 0) {
                stk.push(asteroids[i]);
            }
            else {
                int top = stk.peek();
                if (top*asteroids[i] > 0) {
                    stk.push(asteroids[i]);
                }
                else {
                    if (top < 0 && asteroids[i] > 0) {
                        stk.push(asteroids[i]);
                    }
                    else {
                        while (top > 0 && asteroids[i] < 0
                               && Math.abs(top) < Math.abs(asteroids[i])) {
                            stk.pop();
                            if (stk.size() == 0) {
                                break;
                            }
                            top = stk.peek();
                        }
                        if (top > 0 && asteroids[i] < 0
                               && Math.abs(top) == Math.abs(asteroids[i])) {
                            stk.pop();
                        }
                        else if (stk.size() == 0
                           || top*asteroids[i] > 0) {
                            stk.push(asteroids[i]);
                        }
                    }
                }
            }
        }
        
        Stack<Integer> stkRev = new Stack();
        while (stk.size() > 0) {
            stkRev.push(stk.pop());
        }
        int[] result = new int[stkRev.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = stkRev.pop();
        }
        return result;
    }
}

/*
[-2,-1,1,2]
*/