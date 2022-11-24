class Solution {
    public boolean isStrobogrammatic(String num) {
        int left = 0;
        int right = num.length()-1;
        int[] reverse = new int[]{0,1,-1,-1,-1,-1,9,-1,8,6};
        while (left <= right) {
            int lnum = num.charAt(left)-'0';
            int rnum = num.charAt(right)-'0';
            if (reverse[lnum] == -1
            || reverse[rnum] == -1
            || reverse[lnum] != rnum) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}