class Solution {
    public List<String> findStrobogrammatic(int n) {
        HashMap<Character, Character> map = new HashMap();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
        List<String> ans = new ArrayList();
        backtrack(0, n, "", ans);
        return ans;
    }
    
    public void backtrack(int pos, int n, String built, List<String> ans) {
        if (pos == n) {
            ans.add(built);
            return;
        }
        if (pos == 0
           && n % 2 == 1) {
            backtrack(1, n, "0", ans);
            backtrack(1, n, "1", ans);
            backtrack(1, n, "8", ans);
        }
        else {
            backtrack(pos+2, n, "1"+built+"1", ans);
            backtrack(pos+2, n, "6"+built+"9", ans);
            backtrack(pos+2, n, "8"+built+"8", ans);
            backtrack(pos+2, n, "9"+built+"6", ans);
            if (pos+2 != n) {
                backtrack(pos+2, n, "0"+built+"0", ans);
            }
        }
    }
    
}