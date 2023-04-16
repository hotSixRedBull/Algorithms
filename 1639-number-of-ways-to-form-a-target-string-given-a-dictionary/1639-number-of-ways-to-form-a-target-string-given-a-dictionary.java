class Solution {
    int n;
    int m;
    int k;
    long[][] dp;
    int[][] cnt;
    String target;
    long mod;
    public int numWays(String[] words, String target) {
        n = words.length;
        m = words[0].length();
        k = target.length();
        dp = new long[m][k];
        cnt = new int[26][m];
        this.target = target;
        mod = 1_000_000_007;
        for (String word : words) {
            for (int i=0; i<m; i++) {
                cnt[word.charAt(i)-'a'][i]++;
            }
        }
        for (int i=0; i<m; i++) {
            for (int j=0; j<k; j++) {
                dp[i][j] = -1;
            }
        }
        return (int)recursive(m-1,k-1);
    }
    public long recursive(int pos, int targetPos) {
        if (targetPos == -1) {
            return 1;
        }
        if (pos == -1) {
            return 0;
        }
        if (dp[pos][targetPos] != -1) {
            return dp[pos][targetPos];
        }
        long result = recursive(pos-1, targetPos);
        long posCnt = (long)cnt[target.charAt(targetPos)-'a'][pos];
        if (posCnt > 0) {
            result += posCnt*recursive(pos-1, targetPos-1);
            result %= mod;
        }
        // System.out.println(String.format("dp[%d][%d]: %d",pos,targetPos, (int)result%mod));
        return dp[pos][targetPos] = result%mod;
    }
}