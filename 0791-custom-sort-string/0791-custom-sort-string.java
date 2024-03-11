class Solution {
    public String customSortString(String order, String s) {
        int[] cnt = new int[26];
        for (int i=0; i<s.length(); i++) {
            cnt[s.charAt(i)-'a']++;
        }
        String result = "";
        for (int i=0; i<order.length(); i++) {
            if (cnt[order.charAt(i)-'a'] > 0) {
                for (int j=0; j<cnt[order.charAt(i)-'a']; j++) {
                    result = result + order.charAt(i);
                }
                cnt[order.charAt(i)-'a'] = 0;
            }
        }
        for (int i=0; i<26; i++) {
            for (int j=0; j<cnt[i]; j++) {
                result = result + (char)(i+(int)'a');
            }
        }
        return result;
    }
}