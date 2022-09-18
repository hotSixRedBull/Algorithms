class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        for (int i=0; i<height.length; i++) {
            left[i] = leftMax;
            right[height.length-1-i] = rightMax;
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[height.length-1-i]);
        }
        int sum = 0;
        for (int i=0; i<height.length; i++) {
            if (height[i] < left[i]
               && height[i] < right[i]) {
                int toAdd = Math.min(left[i], right[i])-height[i];
                // System.out.println(String.format("(%d, %d, %d)", left[i], height[i], right[i]));
                sum += toAdd;
            }
        }
        return sum;
    }
}

/*
solved on my own
*/
