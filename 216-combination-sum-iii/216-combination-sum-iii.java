class Solution {
    static List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList();
        backtrack(0, 1, new ArrayList(), k, n);
        return ans;
    }
    public void backtrack(int cur, int start, List<Integer> built, int k, int n) {
        if (cur == k) {
            if (n == 0) {
                ans.add(new ArrayList(built));
            }
            return;
        }        
        if (start == 10) {
            return;
        }
        for (int i=start; i<10; i++) {
            built.add(i);
            backtrack(cur+1, i+1, built, k, n-i);
            built.remove(built.size()-1);
        }
    }
}