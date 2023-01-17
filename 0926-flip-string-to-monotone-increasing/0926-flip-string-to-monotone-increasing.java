class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] leftOne = new int[n];
        int[] rightZero = new int[n];
        int leftOneOffset = 0;
        int rightOneOffset = 0;
        for (int i=0; i<n; i++) {
            if (s.charAt(i) == '1') {
                leftOneOffset = 1;
            }
            else {
                leftOneOffset = 0;
            }
            leftOne[i] = i > 0 ? leftOne[i-1]+leftOneOffset : leftOneOffset;
            if (s.charAt(n-1-i) == '0') {
                rightOneOffset = 1;
            }
            else {
                rightOneOffset = 0;
            }
            rightZero[n-1-i] = i > 0 ? rightZero[n-1-i+1]+rightOneOffset : rightOneOffset;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
            min = Math.min(min, rightZero[i]+leftOne[i]-1);
        }
        return min;
    }
}