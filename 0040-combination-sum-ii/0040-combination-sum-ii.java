class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList();
        Arrays.sort(candidates);
        constructCombination(candidates, target, 0, 0, new ArrayList());
        return ans;
    }
    public void constructCombination(int[] arr, int target, int index, int sum, List<Integer> built) {
        if (sum > target) {
            return;
        }
        
        if (sum == target) {
            ans.add(built);
            return;
        }
        Set<Integer> used = new HashSet();
        for (int i=index; i<arr.length; i++) {
            if (sum + arr[i] > target) {
                break;
            }
            if (used.contains(arr[i])) {
                continue;
            }
            used.add(arr[i]);
            List<Integer> newBuilt = new ArrayList(built);
            newBuilt.add(arr[i]);
            constructCombination(arr, target, i+1, sum+arr[i], newBuilt);
        }
    }
}