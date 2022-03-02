class Solution {
    public boolean squareIsWhite(String coordinates) {
        int alphabet = (int)(coordinates.charAt(0)-'a');
        int number = (int)(coordinates.charAt(1)-'1');
        if (alphabet % 2 == 0) {
            return number % 2 == 1;
        }
        else {
            return number % 2 == 0;
        }
    }
}