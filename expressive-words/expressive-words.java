class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for (String word : words) {
            int i = 0;
            int j = 0;
            boolean isOkay = true;
            while (i < s.length()
                  && j < word.length()) {
                char sChar = s.charAt(i);
                char wChar = word.charAt(j);
                if (sChar != wChar) {
                    // System.out.println("different char");
                    isOkay = false;
                    break;
                }
                
                int sCnt = 0;
                while (i < s.length()
                       && s.charAt(i) == sChar) {
                    i++;
                    sCnt++;
                }
                int wCnt = 0;
                while (j < word.length()
                       && word.charAt(j) == wChar) {
                    j++;
                    wCnt++;
                }
                if ((sCnt < 3 && sCnt != wCnt)
                   || sCnt < wCnt) {
                    // System.out.println("cannot be stretched, "+sChar);
                    isOkay = false;
                    break;
                }
            }
            if (i < s.length() || j < word.length()) {
                isOkay = false;
            }
            if (isOkay) {
                ans++;
            }
        }
        return ans;
    }
}