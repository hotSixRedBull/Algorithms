class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int mod = 1_000_000_007;
        long[] dp = new long[high+1];
        dp[0] = 1;
        for (int i=0; i<=high; i++) {
            if (i + zero <= high) {
                dp[i+zero] += dp[i];
                dp[i+zero] %= mod;
            }
            if (i + one <= high) {
                dp[i+one] += dp[i];
                dp[i+one] %= mod;
            }
        }
        System.out.println(Arrays.toString(dp));
        long result = 0;
        for (int i=low; i<=high; i++) {
            result += dp[i];
            result %= mod;
        }
        return (int) result;
    }
}