class Solution {
    public int[] findPermutation(String s) {
        int[] ans = new int[s.length()+1];
        ans[0] = 1;
        int i = 1;
        while (i <= s.length()) {
            ans[i] = i+1;
            int j = i;
            if (s.charAt(i-1) == 'D') {
                while (i <= s.length()
                      && s.charAt(i-1) == 'D') {
                    i++;
                }
                int toFill = i;
                for (int k=j-1; k<=i-1; k++) {
                    ans[k] = toFill--;
                }
            }
            else {
                i++;
            }
        }
        return ans;
    }
}