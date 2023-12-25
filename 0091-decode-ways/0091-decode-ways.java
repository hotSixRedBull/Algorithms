class Solution {
    int n;
    int[] cache;
    public int numDecodings(String s) {
        n = s.length();
        cache = new int[n];
        Arrays.fill(cache, -1);
        int result = dp(s, 0);
        // System.out.println(Arrays.toString(cache));
        return result;
    }
    public int dp(String s, int pos) {
        if (pos == n) {
            return 1;
        }
        if (cache[pos] != -1) {
            return cache[pos];
        }
        if (s.charAt(pos) == '0') {
            return cache[pos] = 0;
        }
        int result = 0;
        if (pos < n-1) {
            int val = s.charAt(pos)-'0';
            int nextVal = s.charAt(pos+1)-'0';
            if ((val == 2 && nextVal <= 6)
               || val == 1) {
                result += dp(s, pos+2);
            }
        }
        result += dp(s, pos+1);
        cache[pos] = result;
        return cache[pos];
    }
}