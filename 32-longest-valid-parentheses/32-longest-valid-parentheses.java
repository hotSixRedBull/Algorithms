class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i-1) == '('
               && s.charAt(i) == ')') {
                if (i >= 2) {
                    dp[i] = dp[i-2] + 2;
                }
                else {
                    dp[i] = 2;
                }
            }
            if (s.charAt(i-1) == ')'
               && s.charAt(i) == ')'
               && i-dp[i-1]-1 >= 0
               && s.charAt(i-dp[i-1]-1) == '(') {
                if (i-1-dp[i-1]-1 >= 0) {
                    dp[i] = dp[i-1] + dp[i-1-dp[i-1]-1] + 2;
                }
                else {
                    dp[i] = dp[i-1] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}