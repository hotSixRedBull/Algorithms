class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        Arrays.sort(happiness);
        int t = 0;
        long sum = 0;
        for (int i=n-1; i>=n-k; i--) {
            sum += Math.max(0, happiness[i]-t);
            t++;
        }
        return sum;
    }
}

/*
[12,1,42]
3
*/