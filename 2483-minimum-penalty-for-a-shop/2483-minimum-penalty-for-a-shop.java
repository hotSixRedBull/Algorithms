class Solution {
    public int bestClosingTime(String customers) {
        int max = 0;
        int cur = 0;
        int ans = 0;
        for (int i=0; i<customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                cur++;
            }
            else {
                cur--;
            }
            
            if (max < cur) {
                ans = i+1;
                max = cur;
            }
        }
        return ans;
    }
}