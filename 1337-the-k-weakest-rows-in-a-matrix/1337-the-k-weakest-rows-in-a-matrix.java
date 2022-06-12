class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] soldiers = new int[mat.length];
        PriorityQueue<Integer> q = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (soldiers[a] == soldiers[b]) {
                    return a-b;
                }
                return soldiers[a]-soldiers[b];
            }
        });
        for (int i=0; i<mat.length; i++) {
            int lo = 0;
            int hi = mat[i].length-1;
            while (lo < hi) {
                int mid = lo - (lo - hi) / 2;
                if (mat[i][mid] == 1) {
                    lo = mid+1;
                } 
                else {
                    hi = mid;
                }
            }
            if (mat[i][lo] == 1) {
                soldiers[i] = lo+1;
            }
            else {
                soldiers[i] = lo;
            }
            q.add(i);
        }
        int[] ans = new int[k];
        for (int i=0; i<k; i++) {
            ans[i] = q.poll();
        }
        return ans;
    }
}