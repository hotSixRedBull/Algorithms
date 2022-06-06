class Solution {
    public int mySqrt(int x) {
        long lo = 1;
        long hi = x;
        while (lo <= hi) {
            long mid = lo - (lo - hi) / 2;
            // System.out.println(String.format("lo: %d, hi: %d, mid: %d", lo, hi, mid));
            long square = mid*mid;
            if (square == x) {
                return (int)mid;
            }
            if (square < x) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        if (lo*lo > x) {
            return (int)lo-1;
        }
        return (int)lo;
    }
}