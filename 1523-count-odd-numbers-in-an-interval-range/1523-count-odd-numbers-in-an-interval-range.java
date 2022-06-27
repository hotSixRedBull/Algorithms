class Solution {
    public int countOdds(int low, int high) {
        int cnt = 0;
        if (low % 2 == 1) {
            low++;
            cnt++;
        }
        if (high % 2 == 1) {
            high--;
            cnt++;
        }
        cnt += (high-low)/2;
        return cnt;
    }
}