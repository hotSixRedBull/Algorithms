class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> set = new TreeSet();
        for (int num : nums) {
            if (set.size() == 0) {
                set.add(num);
            }
            else {
                if (set.contains(num)) {
                    continue;
                }
                int largest = set.last();
                if (largest < num) {
                    set.add(num);
                }
                else {
                    Integer larger = set.higher(num);
                    set.remove(larger);
                    set.add(num);
                }
            }
        }
        return set.size();
    }
}