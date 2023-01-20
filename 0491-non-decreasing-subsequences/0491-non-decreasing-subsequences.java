class Solution {
    int[] n;
    Set<List<Integer>> ans;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new HashSet();
        n = nums;
        recursive(0, new Stack());
        return new ArrayList(ans);
    }
    
    public void recursive(int cur, Stack<Integer> built) {
        // System.out.println(String.format("cur: %d, stack: %s", cur, built));
        if (built.size() > 1) {
            List<Integer> li = new ArrayList(built);
            for (int i=1; i<li.size(); i++) {
                if (li.get(i) < li.get(i-1)) {
                    return;
                }
            }
            ans.add(new ArrayList(built));
        }
        for (int i=cur; i<n.length; i++) {
            built.add(n[i]);
            recursive(i+1, built);
            built.pop();
        }
    }
}