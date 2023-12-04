class Solution {
    public String largestGoodInteger(String num) {
        int max = -1;
        int n = num.length();
        for (int i=2; i<n; i++) {
            if (num.charAt(i-2) == num.charAt(i-1)
               && num.charAt(i-1) == num.charAt(i)) {
                int val = num.charAt(i)-'0';
                max = Math.max(max, val);
            }
        }
        
        if (max == -1) {
            return "";
        }
        
        String result = "";
        for (int i=0; i<3; i++) {
            result += (char)(max + '0');
        }
        return result;
    }
}