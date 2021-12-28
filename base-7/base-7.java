class Solution {
    public String convertToBase7(int num) {
        StringBuilder str = new StringBuilder();
        boolean isNegative = false;
        if (num == 0) {
            return "0";
        }
        if (num < 0) {
            num = num*(-1);
            isNegative = true;
        }
        while (num > 0) {
            int remainder = num%7;
            str.append(String.valueOf(remainder));
            num /= 7;
        }
        String ans = "";
        if (isNegative) {
            ans += "-";
        }
        return ans+str.reverse().toString();
    }
}