class Solution {
    public int titleToNumber(String columnTitle) {
        int res = 0;
        for (int i=0; i<columnTitle.length(); i++) {
            res *= 26;
            res += columnTitle.charAt(i) - 'A' + 1;
        }
        return res;
    }
}