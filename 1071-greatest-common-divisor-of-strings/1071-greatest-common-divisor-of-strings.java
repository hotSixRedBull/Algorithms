class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int gcd = getGCD(str1.length(), str2.length());
        String ret = "";
        for (int i=1; i<=gcd; i++) {
            String toCheck = str1.substring(0, i);
            if (isDivisable(str1, i)
               && isDivisable(str2, i)
               && toCheck.equals(str2.substring(0, i))) {
                ret = toCheck;
            }
        }
        return ret;
    }
    
    public boolean isDivisable(String s, int len) {
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != s.charAt(i%len)) {
                return false;
            }
        }
        return true;
    }
    
    public int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        if (b > a) {
            return getGCD(b, a);
        }
        return getGCD(b, a%b);
    }
}