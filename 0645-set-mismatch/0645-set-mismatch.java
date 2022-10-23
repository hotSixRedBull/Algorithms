class Solution {
    public int[] findErrorNums(int[] nums) {
        Set<Integer> origin = new HashSet();
        for (int i=1; i<=nums.length; i++) {
            origin.add(i);
        }
        int[] ans = new int[2];
        for (int num : nums) {
            if (origin.contains(num) == false) {
                ans[0] = num;
            }
            origin.remove(num);
        }
        for (int num : origin) {
            ans[1] = num;
        }
        return ans;
    }
}