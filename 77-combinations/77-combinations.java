class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList();
        backtrack(0, new ArrayList(), n, k, answer);
        return answer;
    }
    public void backtrack(int pos, List<Integer> built, int n, int k, List<List<Integer>> ans) {
        if (pos == k) {
            ans.add(new ArrayList(built));
            return;
        }
        int last = pos > 0 ? built.get(pos-1)+1 : 1;
        for (int i=last; i<=n; i++) {
            built.add(i);
            backtrack(pos+1, built, n, k, ans);
            built.remove(pos);
        }
    }
}