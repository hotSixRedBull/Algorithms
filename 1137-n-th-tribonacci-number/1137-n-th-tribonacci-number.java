class Solution {
    int[] dp;
    public Solution() {
        dp = new int[38];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
    }
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        dp[n] = tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
        return dp[n];
    }
}