class Solution {
    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int prevPrev = 0;
        int prev = 1;
        int cur = 1;
        for (int i=2; i<=n; i++) {
            cur = prev + prevPrev;
            prevPrev = prev;
            prev = cur;
        }
        return cur;
    }
}

/*
famous problem.
A1. top-down
A2. bottom-Up
A3. constant space
*/