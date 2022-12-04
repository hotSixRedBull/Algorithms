class Solution {
    public int minimumAverageDifference(int[] nums) {
        long sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
        }
        long leftSum = 0;
        long minDiff = Integer.MAX_VALUE;
        int index = 0;
        for (int i=0; i<nums.length; i++) {
            leftSum += nums[i];
            sum -= nums[i];
            long leftAvg = (long) Math.floor(leftSum/(i+1));
            long rightAvg = i == nums.length-1 ? 0 : (long) Math.floor(sum/(nums.length-i-1));
            long avgDiff = Math.abs(leftAvg-rightAvg);
            // System.out.println(avgDiff);
            if (minDiff > avgDiff) {
                minDiff = avgDiff;
                index = i;
            }
        }
        return index;
    }
}

/*
get Sum (O(N)) + scannig (O(N))
*/