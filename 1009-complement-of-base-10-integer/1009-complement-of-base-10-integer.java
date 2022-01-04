class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }
        int cur = 0;
        int ans = 0;
        int pos = 0;
        while (n > 0) {
            cur = 1 ^ (n & 1);
            ans += cur << pos;
            n = n >>> 1;
            pos++;
        }
        return ans;
    }
}