/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1;
        int hi = n;
        while (lo <= hi) {
            int mid = lo - (lo-hi)/2;
            boolean isBad = isBadVersion(mid);
            if (isBad == false) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return lo <= n && isBadVersion(lo) == true ? lo : lo-1;
    }
}