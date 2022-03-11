class Solution {
    public int countLetters(String s) {
        int ans = 0;
        int sequence = 0;
        char prev = '@';
        for (char c : s.toCharArray()) {
            if (c != prev) {
                ans += sequence*(sequence+1)/2;
                sequence = 1;
                prev = c;
            }
            else {
                sequence++;
            }
        }
        ans += sequence*(sequence+1)/2;
        return ans;
    }
}