class Solution {
    public int removePalindromeSub(String s) {
        int left = 0;
        int right = s.length()-1;
        while (s.charAt(left) == s.charAt(right) && left <= right) {
            left++;
            right--;
        }
        if (left > right) {
            return 1;
        } 
        else {
            return 2;
        }
    }
}