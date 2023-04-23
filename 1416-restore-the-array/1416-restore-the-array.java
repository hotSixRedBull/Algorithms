class Solution {
    int n;
    String s;
    int k;
    long mod;
    long[] dp;
    public int numberOfArrays(String s, int k) {
        this.n = s.length();
        this.s = s;
        this.k = k;
        this.mod = 1_000_000_007;
        dp = new long[n];
        Arrays.fill(dp, -2);
        long result = recursive(n-1);
        // System.out.println("dp" + Arrays.toString(dp));
        if (result == -1) {
            return 0;
        }
        else {
            return (int) (result%mod);
        }
    }
    public long recursive(int pos) {
        if (pos == -1) {
            return 0;
        }
        if (pos == 0) {
            return 1;
        }
        if (dp[pos] != -2) {
            return dp[pos];
        }
        long result = 0;
        long num = 0;
        long redix = 1;
        boolean reachEnd = true;
        // System.out.println(">>>");
        for (int i=pos; i>=0; i--) {
            num += (s.charAt(i)-'0')*redix;
            redix *= 10;
            // System.out.println("num"+ num);
            if (num > k
               || (Math.log10(redix) > 10)) {
                reachEnd = false;
                break;
            }
            if (s.charAt(i) == '0') {
                continue;
            }
            result += recursive(i-1);
            result %= mod;
        }
        
        if (reachEnd) { //like, 1317 in pos=4
            result++;
        }
        return dp[pos] = result;
    }
}
/*
1. brute force
 use walls with 10^5-1 and select it from 1 to 10^5-1 and validate it


- 0 is the special case. It must be belonged to the front group.
- dp[i] => If we end the string at ith string, how many cases do we get?
  - dp[0] => 1
  - dp[i] => 
    - if (s[i] == '0'), same as dp[i-1] 
      - we must calculate the                                                                                                                                                                        
    - if (s[i] != '0'), 
    
    
"29332377127524136126230870622335669657843168529455118482387145131383156269464392206602503504142"
818

*/