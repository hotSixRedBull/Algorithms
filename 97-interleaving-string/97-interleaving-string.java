//saw solution
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[] = new boolean[s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[j] = true;
                } else if (i == 0) {
                    dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s2.length()];
    }
}

/*
class Solution {
    boolean found;
    public boolean isInterleave(String s1, String s2, String s3) {
        found = false;
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        interleave(0,0,0,s1,s2,s3);
        return found;
    }
    
    public void interleave(int pos1, int pos2, int pos3, String s1, String s2, String s3) {
        // System.out.println(String.format("pos1: %d, pos2: %d, pos3: %d",pos1,pos2,pos3));
        if (found) {
            return;
        }
        if (pos3 == s3.length()) {
            found = true;
            return;
        }
        if (pos1 < s1.length()) {
            // System.out.println("?");
            if (s1.charAt(pos1) == s3.charAt(pos3)) {
                if (pos2 < s2.length()) {
                    if (s2.charAt(pos2) == s3.charAt(pos3)) {
                        interleave(pos1+1, pos2, pos3+1, s1, s2, s3);
                        interleave(pos1, pos2+1, pos3+1, s1, s2, s3);
                    }
                    else {
                        interleave(pos1+1, pos2, pos3+1, s1, s2, s3);
                    }
                }
                else {
                    interleave(pos1+1, pos2, pos3+1, s1, s2, s3);
                }
            }
            else if (pos2 < s2.length()) {
                if (s2.charAt(pos2) == s3.charAt(pos3)) {
                    interleave(pos1, pos2+1, pos3+1, s1, s2, s3);
                }
                else {
                    return;
                }
            }
            else {
                return;
            }
        }
        else if (pos2 < s2.length()) {
            if (s2.charAt(pos2) == s3.charAt(pos3)) {
                interleave(pos1, pos2+1, pos3+1, s1, s2, s3);
            }
            else {
                return;
            }
        }
        else {
            return;
        }
    }
}
*/

/*
"ab"
"bc"
"bcab"
*/