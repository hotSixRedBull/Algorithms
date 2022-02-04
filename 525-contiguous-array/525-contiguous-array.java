class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> indexMap = new HashMap();
        int sum = 0;
        int max = 0;
        indexMap.put(0, -1);
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            sum += num == 0 ? -1 : 1;
            if (indexMap.containsKey(sum)) {
                max = Math.max(max, i - indexMap.get(sum));
            }
            else {
                indexMap.put(sum, i);
            }
        }
        return max;
    }
}