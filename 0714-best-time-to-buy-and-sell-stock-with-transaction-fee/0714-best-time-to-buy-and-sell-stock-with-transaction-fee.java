class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] free = new int[n];
        hold[0] = -prices[0];
        free[0] = 0;
        
        for (int i=1; i<n; i++) {
            hold[i] = Math.max(hold[i-1], free[i-1]-prices[i]);
            free[i] = Math.max(free[i-1], hold[i-1]+prices[i]-fee);
        }
        
        return Math.max(hold[n-1], free[n-1]);
    }
}