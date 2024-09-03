import java.math.BigInteger;

class Solution {
    public int getLucky(String s, int k) {
        String str = "";
        for (int i=0; i<s.length(); i++) {
            str = str + Integer.toString((int)(s.charAt(i)-'a'+1));
        }
        BigInteger b = new BigInteger(str);
        // System.out.println(b);
        for (int i=0; i<k; i++) {
            b = transform(b);
            // System.out.println(b);
        }
        return b.intValue();
    }
    public BigInteger transform(BigInteger b) {
        BigInteger result = BigInteger.ZERO;
        String str = b.toString(10);
        for (int i=0; i<str.length(); i++) {
            result = result.add(new BigInteger(str.charAt(i)+""));
        }
        return result;
    }
}