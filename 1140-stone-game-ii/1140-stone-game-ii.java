class Solution {
    int[] p;
    int[][][] cache;
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        cache = new int[n+1][n+1][2];
        for (int i=0; i<=n; i++) {
            for (int j=0; j<=n; j++) {
                for (int k=0; k<2; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        this.p = piles;
        return recursive(0, 1, true);
    }
    public int recursive(int cur, int m, boolean isAliceTurn) {
        if (cur >= p.length) {
            return 0;
        }
        if (isAliceTurn && cache[cur][m][0] != -1) {
            return cache[cur][m][0];
        }
        if (!isAliceTurn && cache[cur][m][1] != -1) {
            return cache[cur][m][1];
        }
        int acc = 0;
        int val = isAliceTurn ? 0 : Integer.MAX_VALUE;
        for (int i=1; i<=2*m && cur+i-1<p.length; i++) {
            acc += p[cur+i-1];
            if (isAliceTurn) {
                int local = recursive(cur+i, Math.max(m, i), false) + acc;
                if (val < local) {
                    val = local;
                }
            }
            else {
                int local = recursive(cur+i, Math.max(m, i), true);
                if (val > local) {
                    val = local;
                }
            }
        }
        if (isAliceTurn) {
            return cache[cur][m][0] = val;
        }
        else {
            return cache[cur][m][1] = val;
        }
    }
}