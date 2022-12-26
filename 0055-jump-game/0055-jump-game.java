class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] reachable = new boolean[n];
        reachable[n-1] = true;
        for (int i=nums.length-2; i>=0; i--) {
            int farthest = Math.min (n-1, i+nums[i]);
            boolean loalReachable = false;
            for (int j=farthest; j>i; j--) {
                if (reachable[j]) {
                    loalReachable = true;
                    break;
                }
            }
            reachable[i] = loalReachable;
            // System.out.println(Arrays.toString(reachable));
        }
        return reachable[0] == true;
    }
}