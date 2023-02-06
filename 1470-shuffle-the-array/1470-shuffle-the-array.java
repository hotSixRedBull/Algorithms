class Solution {
    public int[] shuffle(int[] nums, int n) {
        if (n == 1) {
            return nums;
        }
        int xPos = 0;
        int yPos = n;
        int[] result = new int[2*n];
        for (int i=0; i<n; i++) {
            result[2*i] = nums[xPos++];
            result[2*i+1] = nums[yPos++];
        }
        return result;
    }
}

/*
How can i reduce space complexity?
*/