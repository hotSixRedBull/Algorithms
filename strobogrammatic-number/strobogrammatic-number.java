class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num.length() == 1) {
            return num.charAt(0) == '1'
                 || num.charAt(0) == '8'
                 || num.charAt(0) == '0';
        }
        int left = 0;
        int right = num.length()-1;
        while (left <= right) {
            if (!isSame(num.charAt(left), num.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
    public boolean isSame(char a, char b) {
        return (a == '6' && b == '9')
                 || (a == '9' && b == '6')
                 || (a == '1' && b == '1')
                 || (a == '8' && b == '8')
                 || (a == '0' && b == '0');
    }
}