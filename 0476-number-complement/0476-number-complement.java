class Solution {
    public int findComplement(int num) {
        String str = Integer.toBinaryString(num);
        int result = 0;
        for (int i=0; i<str.length(); i++) {
            result *= 2;
            if (str.charAt(i) == '0') {
                result += 1;
            }
        }
        return result;
    }
}