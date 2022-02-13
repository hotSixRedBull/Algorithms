class Solution {
    private int[] numsCopy;
    private List<List<Integer>> ans;
    public List<List<Integer>> subsets(int[] nums) {
        numsCopy = Arrays.copyOf(nums, nums.length);
        ans = new ArrayList();
        recursive(0, new ArrayList());
        return ans;
    }
    
    public void recursive(int cur, List<Integer> list) {
        if (cur == numsCopy.length) {
            ans.add(list);
            return;
        }
        
        recursive(cur+1, new ArrayList(list));
        List<Integer> next = new ArrayList(list);
        next.add(numsCopy[cur]);
        recursive(cur+1, next);
    }
}