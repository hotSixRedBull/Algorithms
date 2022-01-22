class Solution {
    public boolean winnerSquareGame(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=0; i<=n; i++) {
            for (int sqrt=1; sqrt*sqrt<=i; sqrt++) {
                if (dp[i-sqrt*sqrt] == 0) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[n] == 1;
    }
}