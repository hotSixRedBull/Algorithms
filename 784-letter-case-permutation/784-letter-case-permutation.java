class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList();
        backtrack(0, "", ans, s);
        return ans;
    }
    
    public void backtrack(int pos, String built, List<String> ans, String s) {
        if (pos == s.length()) {
            ans.add(built);
            return;
        }
        if (Character.isDigit(s.charAt(pos))) {
            backtrack(pos+1, built+s.charAt(pos), ans, s);
        }
        else {
            backtrack(pos+1, built+Character.toLowerCase(s.charAt(pos)), ans, s);
            backtrack(pos+1, built+Character.toUpperCase(s.charAt(pos)), ans, s);
        }
    }
}