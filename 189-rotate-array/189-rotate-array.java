class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (k > nums.length/2) {
            int kInverse = nums.length-k;
            Stack<Integer> swap = new Stack();
            for (int i=0; i<kInverse; i++) {
                swap.add(nums[i]);
            }
            
            for (int i=0; i+kInverse<nums.length; i++) {
                nums[i] = nums[i+kInverse];
            }
            
            for (int i=nums.length-1; swap.size()>0; i--) {
                nums[i] = swap.pop();
            }
        }
        else {
            Stack<Integer> swap = new Stack();
            for (int i=0; i<k; i++) {
                swap.add(nums[nums.length-1-i]);
            }
            // System.out.println(swap);
            // System.out.println(Arrays.toString(nums));
            for (int i=nums.length-1; i>=k; i--) {
                nums[i] = nums[i-k];
            }
            // System.out.println(Arrays.toString(nums));
            
            for (int i=0; i<k; i++) {
                nums[i] = swap.pop();
            }
            // System.out.println(Arrays.toString(nums));
        }
    }
}