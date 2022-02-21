class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> cntMap = new HashMap();
        for (int num : nums) {
            int cnt = cntMap.getOrDefault(num , 0);
            if (cnt+1 > Math.floor(nums.length/2)) {
                return num;
            }
            cntMap.put(num, cnt+1);
        }
        return -1;
    }
}