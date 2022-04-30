class Solution {
    public String multiply(String num1, String num2) {
        String answer = "0";
        for (int i=0; i<num2.length(); i++) {
            answer = addStringNumbers(answer, multiplyByChar(num1, num2.charAt(i), num2.length()-i-1));
        }
        return answer;
    }
    public String multiplyByChar(String num1, char num, int pos) {
        if (num == '0' || num1.equals("0")) {
            return "0";
        }
        String ret = "";
        for (int i=0; i<pos; i++) {
            ret += "0";
        }
        int carry = 0;
        for (int i=0; i<num1.length(); i++) {
            int a = num1.charAt(num1.length()-1-i)-'0';
            int b = num-'0';
            // System.out.println(String.format("a=%d, b=%d", a, b));
            if (a*b+carry >= 10) {
                int newCarry = (a*b+carry)/10;
                ret = (char)((a*b+carry)%10+'0') + ret;
                carry = newCarry;
            }
            else {
                ret = (char)(a*b+carry+'0') + ret;
                carry = 0;
            }
        }
        while (carry != 0) {
            int a = carry % 10;
            carry /= 10;
            ret = (char)(a+'0') + ret;
        }
        // System.out.println(String.format("%s * %c = %s", num1, num, ret));
        return ret;
    }
    public String addStringNumbers(String num1, String num2) {
        String ret = "";
        int min = Math.min(num1.length(), num2.length());
        int carry = 0;
        for (int i=0; i<min; i++) {
            int a = num1.charAt(num1.length()-1-i)-'0';
            int b = num2.charAt(num2.length()-1-i)-'0';
            // System.out.println(String.format("a=%d, b=%d", a, b));
            if (a+b+carry >= 10) {
                ret = (char)(a+b+carry-10+'0')+ret;
                carry = 1;
            }
            else {
                ret = (char)(a+b+carry+'0')+ret;
                carry = 0;
            }
            // System.out.println(String.format("ret=%s", ret));
        }
        // System.out.println(String.format(">>%s + %s = %s", num1, num2, ret));
        for (int i=min; i<num1.length(); i++) {
            int a = num1.charAt(num1.length()-1-i)-'0';
            if (a+carry >= 10) {
                carry = 1;
                ret = (char)(a+carry-10+'0') + ret;
            }
            else {
                ret = (char)(a+carry+'0') + ret;
                carry = 0;
            }
        }
        for (int i=min; i<num2.length(); i++) {
            int a = num2.charAt(num2.length()-1-i)-'0';
            if (a+carry >= 10) {
                carry = 1;
                ret = (char)(a+carry-10+'0') + ret;
            }
            else {
                ret = (char)(a+carry+'0') + ret;
                carry = 0;
            }
        }
        if (carry != 0) {
            ret = (char)(carry+'0') + ret;
        }
        // System.out.println(String.format("%s + %s = %s", num1, num2, ret));
        return ret;
    }
}