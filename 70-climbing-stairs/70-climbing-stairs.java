class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        cache[0] = 1;
        if (n > 1) {
            cache[1] = 1;
        }
        for (int i=0; i<n; i++) {
            if (i+1 < n) {
                cache[i+1] += cache[i];
            }
            if (i+2 < n) {
                cache[i+2] += cache[i];
            }
        }
        return cache[n-1];
    }
}