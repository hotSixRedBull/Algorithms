class Solution {
    public boolean isPerfectSquare(int num) {
        for (int i=1; i<num; i++) {
            if (i*i == num) {
                return true;
            }
            else if (i*i > num) {
                return false;
            }
        }
        return num == 1;
    }
}