class Solution {
    int n;
    int[] s;
    int[][] dp;
    public String stoneGameIII(int[] stoneValue) {
        this.n = stoneValue.length;
        this.s = stoneValue;
        dp = new int[n][2];
        for (int i=0; i<n; i++) {
            for (int j=0; j<2; j++) {
                    dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int sum = 0;
        for (int num : s) {
            sum += num;
        }
        int score = recursive(0, 1);
        // System.out.println(score);
        if (score < sum - score) {
            return "Bob";
        }
        else if (score > sum-score) {
            return "Alice";
        }
        else {
            return "Tie";
        }
    }
    public int recursive(int cur, int isAliceTurn) {
        if (cur >= n) {
            return 0;
        }
        if (dp[cur][isAliceTurn] != -Integer.MIN_VALUE) {
            return dp[cur][isAliceTurn];
        }
        int acc = 0;
        int maxScore = isAliceTurn == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            if (cur+i >= s.length) {
                break;
            }
            acc += s[cur+i];
            if (isAliceTurn == 1) {
                int score = recursive(cur+i+1, 0);
                score += acc;
                if (score > maxScore) {
                    maxScore = score;
                }
            }
            else {
                int score = recursive(cur+i+1, 1);
                if (score < maxScore) {
                    maxScore = score;
                }
            }
        }
        // System.out.println(String.format("dp[%d][%d] = %s;", cur, isAliceTurn, maxScore));
        return dp[cur][isAliceTurn] = maxScore;
    }
}