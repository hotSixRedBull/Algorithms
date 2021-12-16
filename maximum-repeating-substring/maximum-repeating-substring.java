class Solution {
    private int[] dp;
    public int maxRepeating(String sequence, String word) {
        this.dp = new int[sequence.length()];
        Arrays.fill(this.dp, -1);
        int answer = 0;
        int tmp = 0;
        for (int i=0; i<sequence.length(); i++) {
            if (sequence.charAt(i) == word.charAt(0)) {
                tmp = maximumKRepeating(i, sequence, word);
                answer = Math.max(answer, tmp);
            }
        }
        return answer;
    }
    public int maximumKRepeating(int pos, String sequence, String word) {
        if (this.dp[pos] != -1) {
            return dp[pos];
        }
        int tmp = 0;
        for (int i=pos; i<sequence.length(); i+=word.length()) {
            if (i+word.length() <= sequence.length()
                && sequence.substring(i, i+word.length()).equals(word)) {
                tmp++;
            }
            else {
                break;
            }
        }
        this.dp[pos] = tmp;
        return tmp;
    }
}