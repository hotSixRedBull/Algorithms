class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> set = new HashSet();
        for (int i=0; i<=nums.length; i++) {
            set.add(i);
        }
        
        for (int num : nums) {
            set.remove(num);
        }
        
        List<Integer> li = new ArrayList(set);
        return li.get(0);
    }
}