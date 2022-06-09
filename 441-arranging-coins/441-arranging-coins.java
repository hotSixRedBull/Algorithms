class Solution {
    public int arrangeCoins(int n) {
        long lo=0;
        long hi=n;
        while (lo<=hi) {
            long mid = lo - (lo - hi)/2;
            long sum = mid*(mid+1)/2;
            // System.out.println(sum);
            if (sum == n) {
                return (int) mid;
            }
            if (sum < n) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return (int) lo-1;
    }
}