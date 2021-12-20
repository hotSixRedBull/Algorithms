class Solution {
    public int subtractProductAndSum(int n) {
        int nCopy = n;
        int sum = 0;
        int prod = 1;
        while (nCopy > 0) {
            int cur = nCopy%10;
            sum += cur;
            prod *= cur;
            nCopy /= 10;
        }
        return prod-sum;
    }
}