class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList();
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        dfs(res, s, 0, new ArrayList(), dp);
        return res;
    }
    public static void dfs(List<List<String>> result,
               String s,
               int start,
               List<String> built,
               boolean[][] dp) {
        if (start >= s.length()) {
            result.add(new ArrayList(built));
        }
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end)
               && (end - start <= 2 || dp[start+1][end-1])) {
                dp[start][end] = true;
                built.add(s.substring(start, end + 1));
                dfs(result, s, end+1, built, dp);
                built.remove(built.size()-1);
            }
        }
    }
}