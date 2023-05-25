class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n+1];
        double sum = k > 0 ? 1 : 0;
        dp[0] = 1;
        for (int i=1; i<=n; i++) {
            dp[i] = sum / maxPts;
            if (i < k) {
                sum += dp[i];
            }
            if (i-maxPts >= 0 && i-maxPts < k) {
                sum -= dp[i-maxPts];
            }
        }
        
        double result = 0;
        for (int i=k; i<=n; i++) {
            result += dp[i];
        }
        return result;
    }
}