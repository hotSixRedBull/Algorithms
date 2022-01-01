class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stk = new Stack<>();
        
        for (int i=0; i<asteroids.length; i++) {
            if (stk.size() == 0) {
                stk.add(asteroids[i]);
            }
            else {
                boolean colided = false;
                while (
                    stk.size() > 0
                    && stk.peek() > 0
                    && asteroids[i] < 0
                ) {
                    if (Math.abs(stk.peek()) < Math.abs(asteroids[i])) {
                        stk.pop();
                    }
                    else if (stk.peek() + asteroids[i] == 0) {
                        stk.pop();
                        colided = true;
                        break;
                    }
                    else {
                        colided = true;
                        break;
                    }
                }
                if (!colided) {
                    stk.add(asteroids[i]);
                }
            }
        }
        
        //System.out.println(stk);
        return stk.stream().mapToInt(i->i).toArray();
    }
}