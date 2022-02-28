class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList();
        for (int i=0; i<nums.length; i++) {
            int start = i;
            while (i+1 < nums.length
                   && nums[i]+1 == nums[i+1]) {
                i++;
            }
            if (start == i) {
                list.add(Integer.toString(nums[start]));
            }
            else {
                list.add(String.format("%d->%d", nums[start], nums[i]));
            }
        }
        return list;
    }
}