class Solution {
    public int countOdds(int low, int high) {
        int cnt = (high-low)/2;
        if (low % 2 == 1) {
            cnt++;
        }
        else if(high % 2 == 1) {
            cnt++;
        }
        return cnt;
    }
}