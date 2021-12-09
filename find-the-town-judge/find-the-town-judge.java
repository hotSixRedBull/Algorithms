class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n+1];
        int[] trusted = new int[n+1];
        Arrays.fill(trusts, 0);
        Arrays.fill(trusted, 0);
        
        for (int[] t : trust) {
            trusts[t[0]]++;
            trusted[t[1]]++;
        }
        
        //System.out.println(String.format("trusts: %s",Arrays.toString(trusts)));
        //System.out.println(String.format("trusted: %s",Arrays.toString(trusted)));
        
        for (int i = 1; i <= n; i++) {
            if (trusts[i] == 0 && trusted[i] == n-1) {
                return i;
            }
        }
        
        return -1;
    }
}