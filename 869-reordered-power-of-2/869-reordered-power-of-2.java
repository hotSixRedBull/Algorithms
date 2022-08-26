class Solution {
    public boolean reorderedPowerOf2(int n) {
        int number = 1;
        String numberString = Integer.toString(number);
        String nString = Integer.toString(n);
        while (numberString.length() <= nString.length()) {
            if (isMatch(numberString, nString)) {
                return true;
            }
            number *= 2;
            numberString = Integer.toString(number);
        }
        return false;
    }
    
    public boolean isMatch(String s1, String s2) {
        int[] s1Map = new int[10];
        int[] s2Map = new int[10];
        for (int i=0; i<s1.length(); i++) {
            s1Map[s1.charAt(i)-'0']++;
        }
        for (int i=0; i<s2.length(); i++) {
            s2Map[s2.charAt(i)-'0']++;
        }
        for (int i=0; i<10; i++) {
            if (s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}