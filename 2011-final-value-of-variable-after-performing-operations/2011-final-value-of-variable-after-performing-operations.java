class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int cnt = 0;
        for (String operation : operations) {
            if (operation.charAt(1) == '-') {
                cnt--;
            }
            else {
                cnt++;
            }
        }
        return cnt;
    }
}