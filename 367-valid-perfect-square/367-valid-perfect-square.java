class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1;
        long hi = num;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            // System.out.println(mid);
            long square = mid*mid;
            if (square == num) {
                return true;
            }
            if (square < num) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return false;
    }
}