class Solution {
    public int fixedPoint(int[] arr) {
        int lo = 0;
        int hi = arr.length-1;
        while (lo <= hi) {
            int mid = lo - (lo - hi)/2;
            if (arr[mid] < mid) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return arr.length > lo && arr[lo] == lo ? lo : -1;
    }
}