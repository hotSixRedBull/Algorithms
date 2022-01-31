class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        for (int[] person : accounts) {
        int localMax=0;
        for (int bank : person) {
           localMax+=bank;
         }
        max=Math.max(max, localMax);
      }
        return max;
    }
}