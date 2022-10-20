class Solution {
    public String intToRoman(int num) {
        String str = Integer.toString(num);
        String ans = "";
        if (str.length() >= 4) {
            int cnt = str.charAt(0)-'0';
            String toRepeat = "M";
            ans = ans + toRepeat.repeat(cnt);
        }
        if (str.length() >= 3) {
            int pos = 0;
            String toRepeat = "C";
            if (str.length() >= 4) {
                pos++;
            }
            int cnt = str.charAt(pos)-'0';
            if (cnt == 9) {
                ans = ans + "CM";
            }
            else if (cnt > 5) {
                ans = ans + "D" + toRepeat.repeat(cnt-5);
            }
            else if (cnt == 5) {
                ans = ans + "D";
            }
            else if (cnt == 4) {
                ans = ans + "CD";
            }
            else {
                ans = ans + toRepeat.repeat(cnt);
            }
        }
        if (str.length() >= 2) {
            int pos = 0;
            String toRepeat = "X";
            if (str.length() >= 3) {
                pos++;
            }
            if (str.length() >= 4) {
                pos++;
            }
            int cnt = str.charAt(pos)-'0';
            if (cnt == 9) {
                ans = ans + "XC";
            }
            else if (cnt > 5) {
                ans = ans + "L" + toRepeat.repeat(cnt-5);
            }
            else if (cnt == 5) {
                ans = ans + "L";
            }
            else if (cnt == 4) {
                ans = ans + "XL";
            }
            else {
                ans = ans + toRepeat.repeat(cnt);
            }
        }
        if (str.length() >= 1) {
            int pos = 0;
            String toRepeat = "I";
            if (str.length() >= 2) {
                pos++;
            }
            if (str.length() >= 3) {
                pos++;
            }
            if (str.length() >= 4) {
                pos++;
            }
            int cnt = str.charAt(pos)-'0';
            if (cnt == 9) {
                ans = ans + "IX";
            }
            else if (cnt > 5) {
                ans = ans + "V" + toRepeat.repeat(cnt-5);
            }
            else if (cnt == 5) {
                ans = ans + "V";
            }
            else if (cnt == 4) {
                ans = ans + "IV";
            }
            else {
                ans = ans + toRepeat.repeat(cnt);
            }
        }
        return ans;
    }
}