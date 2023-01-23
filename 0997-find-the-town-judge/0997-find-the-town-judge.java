class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n+1];  //trusts
        int[] trusted = new int[n+1]; //trusted
        for (int[] pair : trust) {
            trusts[pair[0]]++;
            trusted[pair[1]]++;
        }
        for (int i=1; i<=n; i++) {
            if (trusted[i] == n-1
               && trusts[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}