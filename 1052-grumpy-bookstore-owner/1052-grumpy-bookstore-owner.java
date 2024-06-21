class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int[] acc = new int[n+1];
        int[] accWithGrumpy = new int[n+1];
        for (int i=1; i<=n; i++) {
            acc[i] = acc[i-1]+customers[i-1];
            accWithGrumpy[i] = grumpy[i-1] == 1 ? accWithGrumpy[i-1] : accWithGrumpy[i-1]+customers[i-1];
        }
        int max = 0;
        for (int i=minutes-1; i<n; i++) {
            //i-minutes+1 ~ i is using technique
            int local = 0;
            local += getInclusiveSum(accWithGrumpy, i+1, n-1);
            local += getInclusiveSum(accWithGrumpy, 0, i-minutes);
            local += getInclusiveSum(acc, i-minutes+1, i);
            max = Math.max(max, local);
        }
        return max;
    }
    public int getInclusiveSum(int[] acc, int start, int end) {
        return acc[end+1]-acc[start];
    }
}

/*
sliding window?
*/