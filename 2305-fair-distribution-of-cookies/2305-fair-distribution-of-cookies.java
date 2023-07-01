class Solution {
    int[] c;
    int k;
    int n;
    public int distributeCookies(int[] cookies, int k) {
        this.c = cookies;
        this.k = k;
        this.n = cookies.length;
        int[] built = new int[n];
        return recursive(0, built);
    }
    public int recursive(int cur, int[] built) {
        if (cur == n) {
            int max = 0;
            for (int i=0; i<k; i++) {
                max = Math.max(max, built[i]);
            }
            return max;
        }
        
        int min = Integer.MAX_VALUE;
        for (int i=0; i<k; i++) {
            built[i] += c[cur];
            min = Math.min(min, recursive(cur+1, built));
            built[i] -= c[cur];
        }
        return min;
    }
}