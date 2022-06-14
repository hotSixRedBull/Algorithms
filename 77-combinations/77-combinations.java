class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(0, new ArrayList(), ans, n, k);
        return ans;
    }
    
    public void backtrack(int pos, List<Integer> built, List<List<Integer>> ans, int n, int k) {
        if (pos == k) {
            ans.add(new ArrayList(built));
            return;
        }
        int last = pos == 0 ? 1 : built.get(built.size()-1)+1;
        for (int i=last; i<=n; i++) {
            built.add(i);
            backtrack(pos+1, built, ans, n, k);
            built.remove(built.size()-1);
        }
    }
}