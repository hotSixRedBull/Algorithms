class Solution {
    int n;
    int[] l;
    int[][] cache;
    int s;
    int f;
    int mod;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.n = locations.length;
        this.l = locations;
        cache = new int[n][fuel+1];
        for (int i=0; i<n; i++) {
            for (int j=0; j<=fuel; j++) {
                cache[i][j] = -1;
            }
        }
        this.s = start;
        this.f = finish;
        mod = 1_000_000_007;
        return count(start, fuel);
    }
    
    public int count(int cur, int fuel) {
        if (fuel < 0) {
            return 0;
        }
        
        if (cache[cur][fuel] != -1) {
            return cache[cur][fuel];
        }
        if (fuel == 0) {
            if (cur == f) {
                return cache[cur][fuel] = 1;
            }
            return cache[cur][fuel] = 0;
        }
        
        int local = cur == f ? 1 : 0;
        for (int i=0; i<n; i++) {
            if (i == cur) {
                continue;
            }
            local += count(i, fuel-Math.abs(l[i]-l[cur]));
            local %= mod;
        }
        return cache[cur][fuel] = local % mod;
    }
}

/*

*/