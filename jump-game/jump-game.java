class Solution {
    public boolean canJump(int[] nums) {
        boolean[] canJump = new boolean[nums.length];
        canJump[nums.length-1] = true;
        for (int i=nums.length-2; i>=0; i--) {
            int jumpCapability = nums[i];
            for (int j=1; j<=jumpCapability; j++) {
                if (i+j < nums.length && canJump[i+j] == true) {
                    canJump[i] = true;
                    break;
                }
            }
        }
        //System.out.println(Arrays.toString(canJump));
        return canJump[0] == true;
    }
}