class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for (int i=0; i<text1.length(); i++) {
            for (int j=0; j<text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i > 0
                       && j > 0) {
                        dp[i][j] = Math.max(dp[i-1][j-1]+1,
                                            Math.max(dp[i-1][j],
                                                    dp[i][j-1]));
                    }
                    else {
                        dp[i][j] = 1;
                    }
                }
                else {
                    if (i > 0) {
                        if (j > 0) {
                            dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                        }
                        else {
                            dp[i][j] = dp[i-1][j];
                        }
                    }
                    else {
                        if (j > 0) {
                            dp[i][j] = dp[i][j-1];
                        }
                        else {
                            dp[i][j] = 0;
                        }
                    }
                }
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        return dp[n-1][m-1];
    }
}