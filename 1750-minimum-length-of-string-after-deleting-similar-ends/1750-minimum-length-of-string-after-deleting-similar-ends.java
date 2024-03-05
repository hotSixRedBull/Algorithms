class Solution {
    public int minimumLength(String s) {
        int i=0;
        int j=s.length()-1;
        while (i<j) {
            // System.out.println(s.substring(i,j+1));
            int prevI = i;
            int prevJ = j;
            while (i<j && s.charAt(i) == s.charAt(prevJ)) {
                i++;
            }
            while (i<=j && s.charAt(prevI) == s.charAt(j)) {
                j--;
            }
            if (i == prevI && j == prevJ) {
                break;
            }
        }
        return j-i+1;
    }
}