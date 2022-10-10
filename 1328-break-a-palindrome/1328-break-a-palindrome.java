class Solution {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] newStringArr = palindrome.toCharArray();
        boolean changed = false;
        for (int i=0; i<26; i++) {
            for (int j=0; j<newStringArr.length; j++) {
                if (newStringArr[j]-'a' > i
                   && (newStringArr.length % 2 == 0
                      || (newStringArr.length % 2 == 1
                         && j != newStringArr.length/2))) {
                    newStringArr[j] = (char)(i + (int)'a');
                    changed = true;
                    break;
                }
            }
            if (changed) {
                break;
            }
        }
        if (changed == false) {
            newStringArr[newStringArr.length-1] = 'b';
        }
        return new String(newStringArr);
    }
}

/*
"aa"
*/