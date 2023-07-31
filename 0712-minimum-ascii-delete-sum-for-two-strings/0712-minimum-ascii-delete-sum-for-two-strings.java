//saw solution..
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        // Prepare the two-dimensional array
        int m = s1.length(), n = s2.length();
        int[][] computeCost = new int[m + 1][n + 1];

        // Fill in the base case values
        for (int i = 1; i <= m; i++) {
            computeCost[i][0] = computeCost[i-1][0] + s1.charAt(i-1);
        }
        for (int j = 1; j <= n; j++) {
            computeCost[0][j] = computeCost[0][j-1] + s2.charAt(j-1);
        }
        
        // Fill the remaining cells using the Bellman Equation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    computeCost[i][j] = computeCost[i-1][j-1];
                } else {
                    computeCost[i][j] = Math.min(
                        s1.charAt(i-1) + computeCost[i-1][j],
                        s2.charAt(j-1) + computeCost[i][j-1]
                    );
                }
            }
        }
        
        // Return the answer for entire input strings
        return computeCost[m][n];
    }
}
/*
class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        int[][] dp = new int[l1][l2];
        
        for (int r=0; r<l1; r++) {
            for (int c=0; c<l2; c++) {
                dp[r][c] = 20001;
            }
        }
        dp[0][0] = s1.charAt(0) == s2.charAt(0) ? 0 : (int)s1.charAt(0)+(int)s2.charAt(0);
        
        // System.out.println(String.format("s: %d", (int)'s'));
        // System.out.println(String.format("e: %d", (int)'e'));
        for (int r=0; r<l1; r++) {
            for (int c=0; c<l2; c++) {
                if (s1.charAt(r) == s2.charAt(c)) {
                    if (r > 0 && c > 0) {
                        dp[r][c] = dp[r-1][c-1];
                    }
                    if (r > 0) {
                        dp[r][c] = Math.min(dp[r][c], dp[r-1][c]-(int)s2.charAt(c));
                    }
                    if (c > 0) {
                        dp[r][c] = Math.min(dp[r][c], dp[r][c-1]-(int)s1.charAt(r));
                    }
                }
                else {
                    // if (r > 0 && c > 0) {
                    //     dp[r][c] = dp[r-1][c-1]+(int)s1.charAt(r)+(int)s2.charAt(c);
                    // }
                    if (r > 0) {
                        dp[r][c] = Math.min(dp[r][c], dp[r-1][c]+(int)s1.charAt(r));
                    }
                    if (c > 0) {
                        dp[r][c] = Math.min(dp[r][c], dp[r][c-1]+(int)s2.charAt(c));
                    }
                }
            }
            System.out.println(Arrays.toString(dp[r]));
        }
        
        return dp[l1-1][l2-1];
    }
}
*/