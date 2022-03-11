class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int sum = 0;
        int cnt = 0;
        for (int w : weight) {
            sum += w;
            if (sum > 5000) {
                return cnt;
            }
            cnt++;
        }
        return cnt;
    }
}