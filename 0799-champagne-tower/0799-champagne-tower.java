class Solution {
    double[][] dp;
    public double champagneTower(int poured, int query_row, int query_glass) {
        dp = new double[query_row+1][query_row+1];
        for (int i=0; i<=query_row; i++) {
            Arrays.fill(dp[i], -1);
        }
        dp[0][0] = poured;
        double result = pouredQuantity(query_row, query_glass);
        if (result > 1) {
            return 1;
        }
        else {
            return result;
        }
    }
    public double pouredQuantity(int r, int c) {
        // System.out.println(String.format("pouredQuantity(%d, %d)", r,c));
        if (dp[r][c] != -1) {
            // System.out.println(String.format("cache: %f", dp[r][c]));
            return dp[r][c];
        }
        double result = 0;
        if (c > 0) {
            double fromLeft = pouredQuantity(r-1, c-1);
            // System.out.println(String.format("fromLeft: %f", fromLeft));
            if (fromLeft > 1.0) {
                // System.out.println("left is bigger than 1");
                result += (fromLeft-1)/2;
            }
        }
        if (c < r) {
            double fromRight = pouredQuantity(r-1, c);
            // System.out.println(String.format("fromRight: %f", fromRight));
            if (fromRight > 1.0) {
                result += (fromRight-1)/2;
            }
        }
        
        // System.out.println(String.format("result: %f", result));
        dp[r][c] = result;
        return result;
    }
}