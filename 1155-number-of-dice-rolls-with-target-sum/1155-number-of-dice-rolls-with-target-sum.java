class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[] dpPrev = new int[target+1];
        int modulo = 1_000_000_007;
        for (int i=1; i<=k; i++) {
            if (i > target) {
                break;
            }
            dpPrev[i] = 1;
        }
        for (int i=2; i<=n; i++) {
            int[] dpCur = new int[target+1];
            long sum = 0;
            for (int j=i; j<=i*k; j++) {
                if (j > target) {
                    break;
                }
                sum += dpPrev[j-1];
                dpCur[j] = (int)(sum%modulo);
                if (j > k) {
                    sum -= dpPrev[j-k];
                }
            }
            dpPrev = dpCur;
        }
        return dpPrev[target];
    }
}

/*
1111110
0123456
00136
*/