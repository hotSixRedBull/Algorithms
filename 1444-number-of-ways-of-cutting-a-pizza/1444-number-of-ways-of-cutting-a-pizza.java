class Solution {
    long[][][] dp;
    long modulo;
    public int ways(String[] pizza, int k) {
        modulo = 1_000_000_007;
        dp = new long[pizza.length][pizza[0].length()][k];
        for (int r=0; r<pizza.length; r++) {
            for (int c=0; c<pizza[0].length(); c++) {
                for (int piece=0; piece<k; piece++) {
                    dp[r][c][piece] = -1;
                }
            }
        }
        
        recursive(pizza, 0, 0, k-1);
        
        return (int)(dp[0][0][k-1] % modulo);
    }
    public long recursive(String[] pizza, int top, int left, int k) {
        if (top >= pizza.length
           || left >= pizza[0].length()) {
            return 0;
        }
        
        // memoization
        if (dp[top][left][k] != -1) {
            return dp[top][left][k] % modulo;
        }
        
        if (k == 0) {
            for (int r=top; r<pizza.length; r++) {
                for (int c=left; c<pizza[top].length(); c++) {
                    if (pizza[r].charAt(c) == 'A') {
                        return dp[top][left][k] = 1;
                    }
                }
            }
            return dp[top][left][k] = 0;
        }
        
        int result = 0;
        boolean hasAppleTop = false;
        for (int r=top; r<pizza.length; r++) {
            if (!hasAppleTop) {
                for (int c=left; c<pizza[top].length(); c++) {
                    if (pizza[r].charAt(c) == 'A') {
                        hasAppleTop = true;
                        break;
                    }
                }
            }
            if (hasAppleTop) {
                result += recursive(pizza, r+1, left, k-1) % modulo;
                result %= modulo;
            }
        }
        
        boolean hasAppleLeft = false;
        for (int c=left; c<pizza[top].length(); c++) {
            if (!hasAppleLeft) {
                for (int r=top; r<pizza.length; r++) {
                    if (pizza[r].charAt(c) == 'A') {
                        hasAppleLeft = true;
                        break;
                    }
                }
            }
            if (hasAppleLeft) {
                result += recursive(pizza, top, c+1, k-1) % modulo;
                result %= modulo;
            }
        }
        
        return dp[top][left][k] = result % modulo;
    }
}

/*
*/