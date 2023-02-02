class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for (int i=0; i<order.length(); i++) {
            ord[order.charAt(i)-'a'] = i;
        }
        for (int i=1; i<words.length; i++) {
            int index = 0;
            while (index < words[i-1].length()
                  && index < words[i].length()) {
                if (ord[words[i-1].charAt(index)-'a'] > ord[words[i].charAt(index)-'a']) {
                    return false;
                }
                else if (ord[words[i-1].charAt(index)-'a'] < ord[words[i].charAt(index)-'a']) {
                    break;
                }
                index++;
            }
            if (index == words[i].length()
               && words[i-1].length() > index) {
                return false;
            }
        }
        return true;
    }
    
}