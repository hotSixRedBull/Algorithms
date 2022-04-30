class Solution {
    public void nextPermutation(int[] nums) {
        int lastIncreasingIndex = -1;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                lastIncreasingIndex = i+1;
            }
        }
        // Edge case : to initial status
        if (lastIncreasingIndex == -1) {
            // System.out.println("??");
            sortInplace(nums, 0, nums.length);
            return;
        }
        
        // rest cases
        int target = nums[lastIncreasingIndex-1];
        int biggerThanTarget = Integer.MAX_VALUE;
        int biggerIndex = -1;
        for (int i=lastIncreasingIndex-1; i<nums.length; i++) {
            if (nums[i] > target
               && biggerThanTarget > nums[i]) {
                biggerThanTarget = nums[i];
                biggerIndex = i;
            }
        }
        nums[lastIncreasingIndex-1] = biggerThanTarget;
        nums[biggerIndex] = target;
        //sort others
        sortInplace(nums, lastIncreasingIndex, nums.length);
    }
    
    public void sortInplace(int[] nums, int start, int end) {
        for (int i=start; i<end; i++) {
            for (int j=start; j<end-1; j++) {
                if (nums[j] > nums[j+1]) {
                    // System.out.println(String.format("swap %d and %d", nums[j], nums[j+1]));
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
            // System.out.println(Arrays.toString(nums));
        }
    }
}