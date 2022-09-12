class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length-1;
        int score = 0;
        while (left <= right) {
            // System.out.println(String.format("power: %d, score: %d",power,score));
            if (power < tokens[left]) {
                if (left != right
                    && score > 0) {
                    power += tokens[right--];   
                    score--;
                }
                else {
                    break;
                }
            }
            else {
                power -= tokens[left++];
                score++;
            }
        }
        return score;
    }
}

/* 
- Understanding
  - There are power and score
    - score gives me chance to flip a token and get the power of it
    - power gives me chance to get 1 score if i lose the power of the token
  - Get the largest score.
    - so, power is useless at the end
    
- What would be a brute force way?
    - each token has case of either face up or down.
    - try all the way and get the maximum
    - time complexity would be O(2^n)
    
- Questions
    - are inputs sorted? i guess it's not.

- Thinking process
    - i might flip the biggest one with the first score i have
    - if i sort the input,
        - tokens have less powers than others would be my score
        - tokens have more powers than others would be my power
    - Sort and Two pointer?
        - If i don't have a score, i face down the strongest token
        - While i'm having a power, i face up the weakeast token 
        - Time complexity : O(nlogn)
*/