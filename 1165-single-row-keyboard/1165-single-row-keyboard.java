class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] pos = new int[26];
        for (int i=0; i<keyboard.length(); i++) {
            pos[keyboard.charAt(i)-'a'] = i;
        }
        int cur = 0;
        int total = 0;
        for (int i=0; i<word.length(); i++) {
            int nextPos = pos[word.charAt(i)-'a'];
            total += Math.abs(cur-nextPos);
            cur = nextPos;
        }
        return total;
    }
}