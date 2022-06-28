public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n-1);
            cnt++;
        }
        return cnt;
    }
}

/*
n & (n-1) = remove rightmost 1
n & -n = get rightmost 1
*/