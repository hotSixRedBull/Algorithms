//TLE????
class Solution {

    public String makeFancyString(String s) {
        // If the size of the string is less than 3, return it.
        if (s.length() < 3) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        // Start by appending the first two characters to StringBuilder.
        sb.append(s.charAt(0)).append(s.charAt(1));

        // Iterate from the 3rd character onwards.
        for (int i = 2; i < s.length(); ++i) {
            // If the current character is not equal to the previously inserted
            // two characters, then we can add it to the StringBuilder.
            if (
                s.charAt(i) != sb.charAt(sb.length() - 1) ||
                s.charAt(i) != sb.charAt(sb.length() - 2)
            ) {
                sb.append(s.charAt(i));
            }
        }

        // Convert StringBuilder back to String and return.
        return sb.toString();
    }
}
/*
class Solution {
    public String makeFancyString(String s) {
        String ans = "";
        char prev = '0';
        int conseq = 0;
        int len = s.length();
        char[] sArr = s.toCharArray();
        for (int i=0; i<len; i++) {
            char cur = sArr[i];
            if (prev == cur) {
                conseq++;
                if (conseq >= 3) {
                    continue;
                }
            }
            else {
                conseq = 1;
            }
            ans += cur;
            prev = cur;
        }
        return ans;
    }
}
*/