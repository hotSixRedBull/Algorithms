class Solution {
    public String thousandSeparator(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        while (n > 0) {
            int cur = n%10;
            n /= 10;
            sb.append(Integer.toString(cur));
            cnt++;
            if (cnt==3 && n != 0) {
                cnt = 0;
                sb.append(".");
            }
        }
        return sb.reverse().toString();
    }
}