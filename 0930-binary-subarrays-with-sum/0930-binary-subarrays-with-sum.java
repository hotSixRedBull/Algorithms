class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] acc = new int[n+1];
        for (int i=0; i<n; i++) {
            acc[i+1] = acc[i]+nums[i];
        }
        int sum = 0;
        for (int i=0; i<=n; i++) {
            int prev = acc[i];
            int lo = i+1;
            int hi = n;
            while (lo < hi) {
                int mid = (lo+hi-1)/2;
                if (acc[mid]-prev < goal) {
                    lo = mid+1;
                }
                else {
                    hi = mid;
                }
            }
            if (lo > n || acc[lo]-prev != goal) {
                continue;
            }
            int leftEnd = lo;
            hi = n;
            while (lo < hi) {
                int mid = (lo+hi+1)/2;
                if (acc[mid]-prev > goal) {
                    hi = mid-1;
                }
                else {
                    lo = mid;
                }
            }
            if (lo > n || acc[lo]-prev != goal) {
                continue;
            }
            int rightEnd = lo;
            // System.out.println(String.format("(%d,%d~%d)", i, leftEnd, rightEnd));
            sum += rightEnd-leftEnd+1;
        }
        return sum;
    }
}