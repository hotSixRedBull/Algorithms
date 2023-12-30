class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        int[] cnt = new int[26];
        for (String word : words) {
            for (int i=0; i<word.length(); i++) {
                cnt[word.charAt(i)-'a']++;
            }
        }
        for (int i=0; i<26; i++) {
            if (cnt[i] % n != 0) {
                return false;
            }
        }
        return true;
    }
}