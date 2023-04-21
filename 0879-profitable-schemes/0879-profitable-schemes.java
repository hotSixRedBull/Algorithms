class Solution {
    int n;
    int minProfit;
    int[] group;
    int[] profit;
    int m;
    long[][][] cache;
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        this.n = n;
        this.minProfit = minProfit;
        this.group = group;
        this.profit = profit;
        this.m = group.length;
        cache = new long[n+1][m+1][minProfit+1];
        int mod = 1_000_000_007;
        for (int i=0; i<m; i++) {
            for (int j=Math.min(minProfit, profit[i]); j>=0; j--) {
                if (group[i] <= n) {
                    cache[group[i]][i][j]++;
                }
            }
        }
        for (int i=1; i<=n; i++) {
            for (int j=0; j<m; j++) {
                for (int k=0; k<=minProfit; k++) {
                    cache[i][j][k] += cache[i-1][j][k];
                    cache[i][j][k] %= mod;
                }
                // System.out.println(Arrays.toString(cache[i][j]));
            }
        }
        for (int i=1; i<=n; i++) {
            // System.out.println(String.format("n == %d", i));
            // System.out.println(Arrays.toString(cache[i][0]));
            for (int j=1; j<m; j++) {
                for (int k=0; k<=minProfit; k++) {
                    cache[i][j][k] += cache[i][j-1][k];
                    cache[i][j][k] %= mod;
                    if (i >= group[j]) {
                        if (k >= profit[j]) {
                            cache[i][j][k] += cache[i-group[j]][j-1][k-profit[j]];
                            cache[i][j][k] %= mod;
                        }
                        else {
                            cache[i][j][k] += cache[i-group[j]][j-1][0];
                            cache[i][j][k] %= mod;
                        }
                    }
                }
                // System.out.println(Arrays.toString(cache[i][j]));
            }
        }
        if (minProfit == 0) {
             return (int)((cache[n][m-1][minProfit]+1)%mod);
        }
        return (int)(cache[n][m-1][minProfit]%mod);
    }
}

/*
1
1
[2,2,2,2,2]
[1,2,1,1,0]
64
0
[80, 40]
[88, 88]
1
1
[1]
[1]
*/