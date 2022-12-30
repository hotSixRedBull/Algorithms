/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    int m;
    int n;
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dimension = binaryMatrix.dimensions();
        m = dimension.get(0);
        n = dimension.get(1);
        int leftMost = -1;
        for (int i=0; i<m; i++) {
            int lo = 0;
            int hi = leftMost;
            if (hi == -1) {
                if (binaryMatrix.get(i, n-1) == 1) {
                    leftMost = n-1;
                    hi = n-1;
                }
                else {
                    continue;
                }
            }
            else {
                if (binaryMatrix.get(i, hi) != 1) {
                    continue;
                }
            }
            while (lo < hi) {
                int mid = lo - (lo - hi + 1) / 2;
                // System.out.println(String.format("lo: %d, hi: %d, mid: %d",lo,hi,mid));
                if (binaryMatrix.get(i, mid) == 1) {
                    hi = mid;
                }
                else {
                    lo = mid+1;
                }
            }
            leftMost = Math.min(leftMost, lo);
        }
        return leftMost;
    }
}