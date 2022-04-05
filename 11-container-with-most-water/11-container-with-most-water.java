class Solution {
    public int maxArea(int[] height) {
        int lo = 0;
        int hi = height.length-1;
        int maxArea = 0;
        while (lo < hi) {
            int area = Math.min(height[lo], height[hi])*(hi-lo);
            maxArea = Math.max(maxArea, area);
            if (height[lo] < height[hi]) {
                lo++;
            }
            else {
                hi--;
            }
        }
        return maxArea;
    }
}