class Solution {
    public int tribonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (n == 2) {
            return 1;
        }
        int prevPrevPrev = 0;
        int prevPrev = 1;
        int prev = 1;
        int cur = 2;
        for (int i=3; i<=n; i++) {
            cur = prev + prevPrev + prevPrevPrev;
            prevPrevPrev = prevPrev;
            prevPrev = prev;
            prev = cur;
        }
        return cur;
    }
}