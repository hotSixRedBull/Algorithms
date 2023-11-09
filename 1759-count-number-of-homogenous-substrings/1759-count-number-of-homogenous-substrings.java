class Solution {
    public int countHomogenous(String s) {
        int mod = 1_000_000_007;
        int n = s.length();
        char prev = s.charAt(0);
        long cnt = 1;
        long ans = 0;
        for (int i=1; i<n; i++) {
            char cur = s.charAt(i);
            if (prev == cur) {
                cnt++;
            }
            else {
                ans += getCombination(cnt) % mod;
                ans %= mod; 
                cnt = 1;
                prev = cur;
            }
        }
        ans += getCombination(cnt) % mod;
        ans %= mod;
        return (int) ans;
    }
    public long getCombination(long len) {
        if (len == 0) {
            return 0;
        }
        // len + len-1 + len-2 + ... + 1
        return (len+1)*len/2;
    }
}