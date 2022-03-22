class Solution {
    public String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (k > 0 && n > 0) {
            // System.out.println(String.format("k: %d, n: %d, k-n: %d",k, n, k-n));
            if (k-n >= 26) {
                sb.append('z');
                k -= 26;
            }
            else if (k > n) {
                sb.append((char)(k-n+'a'));
                k -= k-n+1;
            }
            else {
                sb.append('a');
                k -= 1;
            }
            n--;
        }
        return sb.reverse().toString();
    }
}