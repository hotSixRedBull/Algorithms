class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int hold = -prices[0];
        int free = 0;
        
        for (int i=1; i<n; i++) {
            int nextHold = Math.max(hold, free-prices[i]);
            int nextFree = Math.max(free, hold+prices[i]-fee);
            hold = nextHold;
            free = nextFree;
        }
        
        return Math.max(hold, free);
    }
}

//read solution