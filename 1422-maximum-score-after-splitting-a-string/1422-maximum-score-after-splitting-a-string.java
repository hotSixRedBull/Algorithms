class Solution {
    public int maxScore(String s) {
        int zeros = 0, ones = 0;
        for (int i=0; i<s.length()-1; i++) {
            if (s.charAt(i) == '0') {
                zeros++;
            }
        }
        if (s.charAt(s.length()-1) == '1') {
            ones++;
        }
        int score = zeros + ones;
        for (int i=0; i<s.length()-2; i++) {
            if (s.charAt(s.length()-1-i-1) == '1') {
                ones++;
            }
            else {
                zeros--;
            }
            // System.out.println(s.length()-1-i+"th: "+ (zeros + ones));
            score = Math.max(score, zeros + ones);
        }
        return score;
    }
}