class Solution {
    public int countNegatives(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;
        int sum = 0;
        for (int r=0; r<M; r++) {
            int lo = 0;
            int hi = N-1;
            while (lo < hi) {
                int mid = lo - (lo - hi) / 2;
                if (grid[r][mid] >= 0) {
                    lo = mid + 1;
                }
                else {
                    hi = mid;
                }
            }
            if (grid[r][lo] < 0) {
                sum += N-1-lo+1;
            }
        }
        return sum;
    }
}
/*
lower/upper bound에서 찾는 값이 없다면?
만약 -1을 찾는다고 해보자.
[0, 1]에서 찾는다고 하면,
lo hi mid
0  1  0
0  -1 0

lo, hi로는 판단할 수 없는 무언가가 발생.
*/