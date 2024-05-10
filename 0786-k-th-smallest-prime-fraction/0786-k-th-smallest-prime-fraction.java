class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            double bval = ((double)b[0]/(double)b[1]);
            double aval = ((double)a[0]/(double)a[1]);
            if (bval > aval) {
                return 1;
            }
            else if (bval == aval) {
                return 0;
            }
            else {
                return -1;
            }
        });
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                pq.add(new int[]{arr[i], arr[j]});
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}