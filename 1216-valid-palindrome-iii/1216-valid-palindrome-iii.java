class Solution {
    Integer memo[][];
    int isValidPalindrome(String s, int i, int j) {

        // Base case, only 1 letter remaining.
        if (i == j)
            return 0;

        // Base case 2, only 2 letters remaining.
        if (i == j - 1)
            return s.charAt(i) != s.charAt(j) ? 1 : 0;

        //Return the precomputed value if exists.
        if (memo[i][j] != null)
            return memo[i][j];

        // Case 1: Character at `i` equals character at `j`
        if (s.charAt(i) == s.charAt(j))
            return memo[i][j] = isValidPalindrome(s, i + 1, j - 1);

        // Case 2: Character at `i` does not equal character at `j`.
        // Either delete character at `i` or delete character at `j`
        // and try to match the two pointers using recursion.
        // We need to take the minimum of the two results and add 1
        // representing the cost of deletion.
        return memo[i][j] = 1 + Math.min(isValidPalindrome(s, i + 1, j), isValidPalindrome(s, i, j - 1));
    }
public boolean isValidPalindrome(String s, int k) {
        memo = new Integer[s.length()][s.length()];

        // Return true if the minimum cost to create a palindrome by only deleting the letters
        // is less than or equal to `k`.
        return isValidPalindrome(s, 0, s.length() - 1) <= k;
    }
};
// memory limit exceed
/*
class Solution {
    String s;
    int[][][] cache;
    public boolean isValidPalindrome(String s, int k) {
        this.s = s;
        int n = s.length();
        cache = new int[n][n][n+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
        int result = dp(0, n-1, k);
        if (result == 0) {
            return false;
        }
        else {
            return true;
        }
    }
    public int dp(int start, int end, int k) {
        // System.out.println(String.format("dp(%d,%d,%d)", start, end, k));
        if (start > end) {
            return 0;
        }
        if (cache[start][end][k] != -1) {
            return cache[start][end][k];
        }
        if (start == end) {
            return cache[start][end][k] = 1;
        }
        int result = 0;
        if (s.charAt(start) == s.charAt(end)) {
            if (start+1 == end) {
                return cache[start][end][k] = 1;
            }
            result |= dp(start+1, end-1, k);
        }
        if (k > 0) {
            result |= dp(start+1, end, k-1);
            result |= dp(start, end-1, k-1);
        }
        return cache[start][end][k] = result;
    }
}
/*
"aaabaabaa"
1
*/