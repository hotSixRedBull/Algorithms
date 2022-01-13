class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '#') {
                Integer twoDigit = Integer.valueOf(s.substring(i-2,i));
                char target = (char)((int)'j'-10+twoDigit);
                sb.append(target);
                i -= 2;
            }
            else {
                char target = (char)((int)'a'-1+Character.getNumericValue(s.charAt(i)));
                sb.append(target);
            }
        }
        return sb.reverse().toString();
    }
}