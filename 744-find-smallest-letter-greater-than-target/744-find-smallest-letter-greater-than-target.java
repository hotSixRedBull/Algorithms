class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length-1;
        while (left < right) {
            int mid = (int)Math.floor(left - (left-right)/2);
            if (letters[mid] <= target) {
                left = mid+1;
            }
            else if (letters[mid] > target) {
                right = mid;
            }
        }
        return letters[left] > target ? letters[left] : letters[0];
    }
}