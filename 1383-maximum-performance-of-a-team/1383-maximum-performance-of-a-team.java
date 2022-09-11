import java.math.*;

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] arr = new int[n][2];
        for (int i=0; i<n; i++) {
            arr[i] = new int[]{speed[i], efficiency[i]};
        }
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? b[0]-a[0] : b[1]-a[1]);
        long max = Long.MIN_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue();
        long sum = 0;
        for (int i=0; i<n; i++) {
            if (i > 0) {
                pq.add(arr[i-1][0]);
                sum += arr[i-1][0];
                if (pq.size() > k-1) {
                    sum -= pq.poll();
                }
            }
            long sp = arr[i][0]+sum;
            long localOptimum = sp*arr[i][1];
            max = Math.max(max, localOptimum);
        }
        return (int) (max % 1_000_000_007);
    }
}