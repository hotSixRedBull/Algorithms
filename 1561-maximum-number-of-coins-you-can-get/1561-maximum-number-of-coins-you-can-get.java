class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int lo = 0;
        int hi = piles.length-1;
        int max = 0;
        while (lo < hi) {
            lo++;
            hi--;
            max += piles[hi--];
        }
        return max;
    }
}