class Solution {
    int n;
    int[] c;
    int[][] dp;
    public int minCost(int n, int[] cuts) {
        this.n = n;
        int m = cuts.length;
        this.c = new int[m+2];
        c[0] = 0;
        for (int i=0; i<m; i++) {
            c[i+1] = cuts[i];
        }
        c[m+1] = n;
        Arrays.sort(c);
        // System.out.println(Arrays.toString(c));
        dp = new int[m+2][m+2];
        for (int i=0; i<m+2; i++) {
            for (int j=0; j<m+2; j++) {
                dp[i][j] = -1;
            }
        }
        return recursive(0, m+1);
    }
    public int recursive(int start, int end) {
        if (start >= end) {
            return 0;
        }
        if (end - start == 1) {
            // System.out.println(String.format("recursive(%d,%d): %d", start, end, c[end]-c[start]));
            return 0;
        }
        if (dp[start][end] != -1) {
            // System.out.println(String.format("recursive(%d,%d): %d", start, end, dp[start][end]));
            return dp[start][end];
        }
        int min = Integer.MAX_VALUE;
        for (int i=start+1; i<=end-1; i++) {
            min = Math.min(min, recursive(start, i) + recursive(i, end));
        }
        // System.out.println(String.format("recursive(%d,%d): %d, min: %d", start, end, min + c[end]-c[start], min));
        return dp[start][end] = min + c[end]-c[start];
    }
}