class Solution {
    double[][] dp;
    public double probabilityOfHeads(double[] prob, int target) {
        int n = prob.length;
        dp = new double[n][target+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<target+1; j++) {
                dp[i][j] = -1;
            }
        }
        return recursive(prob, 0, target);
    }
    
    public double recursive(double[] p, int cur, int left) {
        if (cur == p.length) {
            if (left == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if (dp[cur][left] != -1) {
            return dp[cur][left];
        }
        double sum = 0;
        if (left > 0) {
            sum += recursive(p, cur+1, left-1)*p[cur];
        }
        sum += recursive(p, cur+1, left)*(1-p[cur]);
        return dp[cur][left] = sum;
    }
}