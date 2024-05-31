class Solution {
    public int[] singleNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int num : nums) {
            if (set.contains(num)) {
                set.remove(num);
            }
            else {
                set.add(num);
            }
        }
        int[] ans = new int[2];
        int i = 0;
        for (int num : set) {
            if (i == 2) {
                break;
            }
            ans[i] = num;
            i++;
        }
        return ans;
    }
}