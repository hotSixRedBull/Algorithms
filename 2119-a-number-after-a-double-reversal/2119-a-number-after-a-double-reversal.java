class Solution {
    public boolean isSameAfterReversals(int num) {
        String numString = Integer.toString(num);
        String reversed1 = reverse(numString);
        for (int i=0; i<reversed1.length(); i++) {
            if (reversed1.charAt(i) != '0') {
                reversed1 = reversed1.substring(i, reversed1.length());
                break;
            }
        }
        String reversed2 = reverse(reversed1);
        // System.out.println(String.format("num: %s, r1: %s, r2: %s", numString, reversed1, reversed2));
        return num == Integer.parseInt(reversed2);
    }
    public String reverse(String n) {
        StringBuilder sb = new StringBuilder(n);
        return sb.reverse().toString();
    }
}