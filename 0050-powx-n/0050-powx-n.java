//saw solution T.T
class Solution {
    private double binaryExp(double x, long n) {
        if (n == 0) {
            return 1;
        }

        // Handle case where, n < 0.
        if (n < 0) {
            n = -1 * n;
            x = 1.0 / x;
        }

        // Perform Binary Exponentiation.
        double result = 1;
        while (n != 0) {
            // If 'n' is odd we multiply result with 'x' and reduce 'n' by '1'.
            if (n % 2 == 1) {
                result = result * x;
                n -= 1;
            }
            // We square 'x' and reduce 'n' by half, x^n => (x^2)^(n/2).
            x = x * x;
            n = n / 2;
        }
        return result;
    }

    public double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
}

/*
import java.math.BigDecimal;
import java.math.MathContext;

class Solution {
    public double myPow(double x, int n) {
        BigDecimal result = BigDecimal.valueOf(x);
        if (n < 0) {
            result = result.pow(-n);
            return 1.0/result.doubleValue();
        }
        else {
            result = result.pow(n, MathContext.DECIMAL32);
        }
        return result.doubleValue();
    }
}
/*
0.00001
2147483647
*/