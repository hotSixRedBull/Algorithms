class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int lo = 0;
        int hi = letters.length-1;
        while (lo < hi) {
            int mid = lo - (lo - hi) / 2;
            if (letters[mid] <= target) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        if (letters[lo] <= target) {
            return letters[0];
        }
        return letters[lo];
    }
}