class Solution {
    int[][] dp;
    int m;
    int n;
    String s1,s2,s3;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.s1 = s1;
        this.s2 = s2;
        this.s3 = s3;
        m = s1.length();
        n = s2.length();
        if (m+n != s3.length()) {
            return false;
        }
        dp = new int[m+1][n+1];
        return recursive(0, 0, 0);
    }
    public boolean recursive(int i, int j, int k) {
        // System.out.println(String.format("recursive(%d,%d,%d)",i,j,k));
        if (k == s3.length()) {
            return true;
        }
        if (i > m || j > n) {
            return false;
        }
        if (dp[i][j] != 0) {
            return dp[i][j] == 1 ? true : false;
        }
        boolean result = false;
        if (i < m && s3.charAt(k) == s1.charAt(i)) {
            result |= recursive(i+1, j, k+1);
        }
        if (j < n && s3.charAt(k) == s2.charAt(j)) {
            result |= recursive(i, j+1, k+1);
        }
        dp[i][j] = result == true ? 1 : -1;
        return result;
    }
}