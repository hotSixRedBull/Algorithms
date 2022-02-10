class Solution {
    public boolean isThree(int n) {
        double sqrt = Math.sqrt(n);
        if (sqrt % 1 != 0) {
            return false;
        }
        int sqrtInt = (int) sqrt;
        for (int i=2; i<=Math.sqrt(sqrtInt); i++) {
            if (sqrtInt % i == 0) {
                return false;
            }
        }
        return sqrtInt > 1;
    }
}