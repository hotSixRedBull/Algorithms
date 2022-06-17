public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        char[] toCharArray = Integer.toBinaryString(n).toCharArray();
        // System.out.println(Arrays.toString(toCharArray));
        char[] base = new char[32];
        for (int i=0; i<32-toCharArray.length; i++) {
            base[i] = '0';
        }
        for (int i=0; i<toCharArray.length; i++) {
            base[32-toCharArray.length+i] = toCharArray[i];
        }
        // System.out.println(Arrays.toString(base));
        int i=0;
        int j=31;
        while (i < j) {
            char tmp = base[i];
            base[i] = base[j];
            base[j] = tmp;
            i++;
            j--;
        }
        // System.out.println(Arrays.toString(base));
        String baseString = new String(base);
        int sum = 0;
        for (int index=0; index<32; index++) {
            sum *= 2;
            if (baseString.charAt(index) == '1') {
                sum += 1;
            }
        }
        return sum;
    }
}