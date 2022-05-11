class Solution {
    public int countVowelStrings(int n) {
        //5Hr => n+r-1Cn-1 => 4+rC4
        long acc = 1;
        for (int i=1; i<5; i++) {
            acc *= n+i;
            acc /= i;
        }
        return (int) acc;
    }
}