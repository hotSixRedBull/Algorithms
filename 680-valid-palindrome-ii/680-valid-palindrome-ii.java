class Solution {
    public boolean validPalindrome(String s) {
        int lo=0;
        int hi=s.length()-1;
        while (lo < s.length()
               && s.charAt(lo) == s.charAt(hi)) {
            lo++;
            hi--;
        }
        if (hi <= lo) {
            return true;
        }
        //lo+1~hi
        int loCpy = lo+1;
        int hiCpy = hi;
        while (loCpy < s.length()
               && s.charAt(loCpy) == s.charAt(hiCpy)) {
            loCpy++;
            hiCpy--;
        }
        if (hiCpy <= loCpy) {
            return true;
        }
        //lo~hi-1
        loCpy = lo;
        hiCpy = hi-1;
        while (loCpy < s.length()
               && hiCpy > -1
               && s.charAt(loCpy) == s.charAt(hiCpy)) {
            loCpy++;
            hiCpy--;
        }
        if (hiCpy <= loCpy) {
            return true;
        }
        //else
        return false;
    }
    
}