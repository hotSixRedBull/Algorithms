//saw solution
class Solution {
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            String binary = Integer.toBinaryString(i);
            for (int j = 0; j < binary.length(); j++) {
                result = (result * 2 + (binary.charAt(j) - '0')) % MOD;
            }
        }
        return result;
    }
}

/*
import java.math.BigInteger;

class Solution {
    public int concatenatedBinary(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            String iToBinaryString = Integer.toBinaryString(i);
            sb.append(iToBinaryString);
        }
        String sum = sb.toString();
        // System.out.println(sum);
        BigInteger bi = BigInteger.valueOf(0);
        // System.out.println(Integer.toString((int)Math.pow(2,30),2));
        for (int j=0; j<sum.length(); j+=60) {
            int end = Math.min(j+60, sum.length());
            bi = bi.multiply(BigInteger.valueOf((long)Math.pow(2,end-j)));
            bi = bi.add(BigInteger.valueOf(Long.valueOf(sum.substring(j,end),2)));
        }
        // System.out.println("total bi:"+bi.toString(2));
        return bi.mod(BigInteger.valueOf(1_000_000_007)).intValue();
    }
}
*/