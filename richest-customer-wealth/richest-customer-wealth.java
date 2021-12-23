class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for (int i=0; i<accounts.length; i++) {
            int sum = 0;
            for (int w : accounts[i]) {
                sum += w;
            }
            max = Math.max(max, sum); 
        }
        return max;
    }
}