import java.util.*;
import java.math.*;
class Solution {
    public int uniquePaths(int m, int n) {
        BigInteger ret = BigInteger.valueOf(1);
        int max = Math.max(m-1, n-1);
        int min = Math.min(m-1, n-1);
        for (int i=m+n-2; i>max; i--) {
            ret = ret.multiply(BigInteger.valueOf(i));
        }
        // System.out.println(ret);
        for (int i=2; i<=min; i++) {
            ret = ret.divide(BigInteger.valueOf(i));
        }
        // System.out.println(ret);
        return ret.intValue();
    }
}

/*
permutation with same word
RRRRRRDD
8!/6!2! => 28

RDD
3!/2!1! => 3
*/