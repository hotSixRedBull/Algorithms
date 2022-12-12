class Solution {
    public int climbStairs(int n) {
        if (n < 2) {
            return n;
        }
        int first = 1;
        int second = 1;
        int third = 0;
        for (int i=1; i<n-1; i++) {
            second += first;
            third += first;
            first = second;
            second = third;
            third = 0;
        }
        third = first + second;
        return third;
    }
}

/*

- 1 1
- 1 2 1
- 1 2 3 1
- 1 2 3 4 1

*/