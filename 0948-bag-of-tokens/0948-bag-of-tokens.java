class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int i = 0;
        int j = tokens.length-1;
        Arrays.sort(tokens);
        int max = 0;
        int score = 0;
        while (i <= j) {
            if (tokens[i] <= power) {
                score++;
                power -= tokens[i];
                max = Math.max(max, score);
                i++;
            }
            else {
                if (score == 0) {
                    break;
                }
                score--;
                power += tokens[j];
                j--;
            }
        }
        return max;
    }
}