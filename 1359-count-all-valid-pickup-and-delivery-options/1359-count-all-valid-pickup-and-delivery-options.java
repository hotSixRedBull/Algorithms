import java.math.BigInteger;

class Solution {
    public int countOrders(int n) {
        BigInteger b = BigInteger.valueOf(1);
        for (int i=1; i<=2*n; i++) {
            b = b.multiply(BigInteger.valueOf(i));
        }
        for (int i=1; i<=n; i++) {
            b = b.divide(BigInteger.valueOf(2));
        }
        b = b.mod(BigInteger.valueOf((long)Math.pow(10, 9) + 7));
        return b.intValue();
    }
}