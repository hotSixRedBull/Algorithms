class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int ans = 0;
        for (int i=1; i<timeSeries.length; i++) {
            int diff = timeSeries[i]-timeSeries[i-1];
            if (diff > duration) {
                ans += duration;
            }
            else {
                ans += diff;
            }
        }
        ans += duration;
        return ans;
    }
}