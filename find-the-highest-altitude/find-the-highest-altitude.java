class Solution {
    public int largestAltitude(int[] gain) {
        int acc = 0;
        int max = 0;
        for (int i=0; i<gain.length; i++) {
            acc += gain[i];
            max = Math.max(max, acc);
        }
        return max;
    }
}