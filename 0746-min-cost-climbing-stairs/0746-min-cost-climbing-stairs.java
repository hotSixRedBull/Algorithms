class Solution {
    int n;
    int[] c;
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        this.n = cost.length;
        this.c = cost;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(get(0), get(1));
    }
    public int get(int pos) {
        if (dp[pos] != -1) {
            return dp[pos];
        }
        int cost = c[pos];
        int min = Integer.MAX_VALUE/2;
        if (pos+1 < n) {
            min = Math.min(min, get(pos+1));
        }
        if (pos+2 < n) {
            min = Math.min(min, get(pos+2));
        }
        else {
            min = 0;
        }
        dp[pos] = cost+min;
        // System.out.println(String.format("pos: %d, dp: %s", pos, Arrays.toString(dp)));
        return dp[pos];
    }
}