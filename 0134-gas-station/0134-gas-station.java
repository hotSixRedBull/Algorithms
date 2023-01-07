class Solution {
    int[] g;
    int[] c;
    int n;
    public int canCompleteCircuit(int[] gas, int[] cost) {
        g = gas;
        c = cost;
        n = gas.length;
        for (int i=0; i<n; i++) {
            if (gas[i]-cost[i] < 0) {
                continue;
            }
            
            int res = getLastFailed(i);
            if (res == -1) {
                return i;
            }
            else if (res < i) {
                return -1;
            }
            else {
                i = res-1;
            }
        }
        
        return -1;
    }
    public int getLastFailed(int s) {
        int acc = 0;
        for (int i=s; i<n; i++) {
            acc += g[i]-c[i];
            if (acc < 0) {
                return i;
            }
        }
        for (int i=0; i<s; i++) {
            acc += g[i]-c[i];
            if (acc < 0) {
                return i;
            }
        }
        return -1;
    }
}

/*
Brute force would take square times.

dynamic programming takes that, too.

optimization is,
1. start from the positive profit (gas - cost)
2. Find "fail" point. and start from the fail point.
*/