class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        Arrays.fill(freq, -1);
        for (int i=0; i<s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] >= 0) {
                freq[s.charAt(i) - 'a'] = -2;
            }
            else if (freq[s.charAt(i) - 'a'] == -1) {
                freq[s.charAt(i) - 'a'] = i;
            }
        }
        int ret = -1;
        for (int i=0; i<26; i++) {
            if (freq[i] >= 0) {
                if (ret < 0) {
                    ret = freq[i];   
                }
                else {
                    ret = Math.min(ret, freq[i]);
                }
            }
        }
        return ret < 0 ? -1 : ret;
    }
}