class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int sum = 0;
        for (int[] trip : trips) {
            sum += trip[0];
        }
        if (sum <= capacity) {
            return true;
        }
        
        int[] cap = new int[1001];
        Arrays.fill(cap, 0);
        for (int[] trip : trips) {
            for (int i=trip[1]; i<trip[2]; i++) {
                cap[i]+=trip[0];
                if (cap[i] > capacity) {
                    return false;
                }
            }
        }
        return true;
    }
}