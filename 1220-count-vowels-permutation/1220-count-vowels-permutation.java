class Solution {
    int[][] dp;
    public int countVowelPermutation(int n) {
        dp = new int[n+1][26];
        int MODULO = 1_000_000_007;
        dp[1][0] = 1;
        dp[1]['e'-'a'] = 1;
        dp[1]['i'-'a'] = 1;
        dp[1]['o'-'a'] = 1;
        dp[1]['u'-'a'] = 1;
        int sum = 5;
        for (int i=2; i<=n; i++) {
            int localSum = 0;
            dp[i][0] = dp[i-1]['e'-'a'];
            dp[i]['a'-'a'] %= MODULO;
            dp[i]['e'-'a'] = dp[i-1]['a'-'a'];
            dp[i]['e'-'a'] %= MODULO;
            dp[i]['e'-'a'] += dp[i-1]['i'-'a'];
            dp[i]['e'-'a'] %= MODULO;
            dp[i]['i'-'a'] = dp[i-1]['a'-'a'];
            dp[i]['i'-'a'] %= MODULO;
            dp[i]['i'-'a'] += dp[i-1]['e'-'a'];
            dp[i]['i'-'a'] %= MODULO;
            dp[i]['i'-'a'] += dp[i-1]['o'-'a'];
            dp[i]['i'-'a'] %= MODULO;
            dp[i]['i'-'a'] += dp[i-1]['u'-'a'];
            dp[i]['i'-'a'] %= MODULO;
            dp[i]['o'-'a'] = dp[i-1]['i'-'a'];
            dp[i]['o'-'a'] %= MODULO;
            dp[i]['o'-'a'] += dp[i-1]['u'-'a'];
            dp[i]['o'-'a'] %= MODULO;
            dp[i]['u'-'a'] = dp[i-1]['a'-'a'];
            dp[i]['u'-'a'] %= MODULO;
            
            localSum += dp[i][0];
            localSum %= MODULO;
            localSum += dp[i]['e'-'a'];
            localSum %= MODULO;
            localSum += dp[i]['i'-'a'];
            localSum %= MODULO;
            localSum += dp[i]['o'-'a'];
            localSum %= MODULO;
            localSum += dp[i]['u'-'a'];
            localSum %= MODULO;
            sum = localSum;
        }
        return sum;
    }
}

/*
1. e -> a
2. a,i -> e
3. i !-> i
4. i,u -> o
5. a -> u
*/