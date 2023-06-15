class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;
        List<List<Integer>> results = new ArrayList();
        if (n == 0) {
            results.add(new ArrayList(List.of(lower, upper)));
        }
        
        if (n > 0
            && nums[0] > lower) {
            if (nums[0] == lower-1) {
                results.add(new ArrayList(List.of(lower, lower)));
            }
            else {
                results.add(new ArrayList(List.of(lower, nums[0]-1)));
            }
        }
        
        for (int i=1; i<n; i++) {
            int diff = Math.abs(nums[i]-nums[i-1]);
            if (diff != 1) {
                results.add(new ArrayList(List.of(nums[i-1]+1, nums[i]-1)));
            }
        }
        
        if (n > 0
            && nums[n-1] < upper) {
            if (nums[n-1] == upper-1) {
                results.add(List.of(upper, upper));
            }
            else {
                results.add(List.of(nums[n-1]+1, upper));
            }
        }
        return results;
    }
}
/*
[]
1
1
*/