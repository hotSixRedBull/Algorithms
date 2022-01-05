class Solution {
    public String generateTheString(int n) {
        if (n % 2 == 0) {
            return "a".repeat(n-1)+"b";
        }
        else {
            return n < 2 ? "a" : "a".repeat(n-2)+"bc";
        }
    }
}