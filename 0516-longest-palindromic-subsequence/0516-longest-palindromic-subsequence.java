class Solution {
    int[][] cache;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        cache = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                cache[i][j] = -1;
            }
        }
        recursive(s, 0, n-1);
        // for (int i=0; i<n; i++) {
        //     System.out.println(Arrays.toString(cache[i]));
        // }
        return cache[0][n-1];
    }
    public int recursive(String s, int start, int end) {
        // System.out.println(String.format("s: %s, start: %d, end: %d", s.substring(start, end+1), start, end));
        if (start < 0
           || end >= s.length()
           || start > end) {
            // System.out.println("end, 0");
            return cache[start][end] = 0;
        }
        if (start == end) {
            // System.out.println("1");
            return cache[start][end] = 1;
        }
        if (cache[start][end] != -1) {
            return cache[start][end];
        }
        int max = 0;
        if (s.charAt(start) == s.charAt(end)) {
            max = Math.max(max, recursive(s, start+1, end-1)+2);
        }
        if (start < end) {
            max = Math.max(max, recursive(s, start, end-1));
            max = Math.max(max, recursive(s, start+1, end));
        }
        return cache[start][end] = max;
    }
}