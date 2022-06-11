class Solution {
    public int minOperations(int[] nums, int x) {
        HashMap<Integer, Integer> accMap = new HashMap();
        int[] acc = new int[nums.length];
        acc[0] = nums[0];
        accMap.put(nums[0], 1);
        for (int i=1; i<nums.length; i++) {
            acc[i] = acc[i-1]+nums[i];
            accMap.put(acc[i], i+1);
        }
        HashMap<Integer, Integer> accMap2 = new HashMap();
        int[] acc2 = new int[nums.length];
        acc2[0] = nums[nums.length-1];
        accMap2.put(0, 0);
        accMap2.put(acc2[0], 1);
        for (int i=1; i<nums.length; i++) {
            acc2[i] = acc2[i-1]+nums[nums.length-1-i];
            accMap2.put(acc2[i], i+1);
        }
        
        int ans = Integer.MAX_VALUE;
        if (accMap2.containsKey(x)) {
            ans = Math.min(ans, accMap2.get(x));
        }
        for (int i=0; i<nums.length; i++) {
            if (accMap2.containsKey(x-acc[i])
               && accMap2.get(x-acc[i])+i+1 <= nums.length) {
                ans = Math.min(ans, i+1+accMap2.get(x-acc[i]));
            }
        }
        
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }
}