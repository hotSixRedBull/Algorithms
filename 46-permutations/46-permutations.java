class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        backtrack(0, new ArrayList(), new HashSet(), ans, nums);
        return ans;
    }
    
    public void backtrack(int pos, List<Integer> built, Set<Integer> used, List<List<Integer>> ans, int[] nums) {
        if (pos == nums.length) {
            ans.add(new ArrayList(built));
            return;
        }
        for (int num : nums) {
            if (used.contains(num)) {
                continue;
            }
            built.add(num);
            used.add(num);
            backtrack(pos+1, built, used, ans, nums);
            built.remove(built.get(built.size()-1));
            used.remove(num);
        }
    }
}