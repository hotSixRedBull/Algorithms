class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];
        dp[0] = Math.min(Math.min(costs[0], costs[1]), costs[2]);
        for (int i=1; i<n; i++) {
            int today = days[i];
            int use1day  = dp[i-1] + costs[0];
            int index = binarySearch(days, today-6);
            int use7day  = index == 0 ? costs[1] : dp[index-1] + costs[1];
            index = binarySearch(days, today-29);
            int use30day = index == 0 ? costs[2] : dp[index-1] + costs[2];
            dp[i] = Integer.MAX_VALUE;
            dp[i] = Math.min(dp[i], use1day);
            dp[i] = Math.min(dp[i], use7day);
            dp[i] = Math.min(dp[i], use30day);
            // System.out.println(String.format("today: %d, (%d, %d, %d), dp[%d]: %d", today, use1day, use7day, use30day, i, dp[i]));
        }
        return dp[n-1];
    }
    
    public int binarySearch(int[] days, int target) {
        int lo = 0;
        int hi = days.length-1;
        while (lo < hi) {
            int mid = lo - (lo - hi)/2;
            if (days[mid] < target) {
                lo = mid+1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
}

/*
[1,4,6,7,8,20]
[7,2,15]
*/