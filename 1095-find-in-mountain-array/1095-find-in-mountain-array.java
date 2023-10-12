/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    MountainArray m;
    Map<Integer, Integer> cache;
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int lo = 1;
        int hi = n-2;
        int peak = -1;
        this.m = mountainArr;
        cache = new HashMap();
        while (lo < hi) {
            int mid = lo - (lo - hi)/2;
            int prior = getVal(mid-1);
            int val = getVal(mid);
            int next = getVal(mid+1);
            if (prior < val) {
                if (val > next) {
                    peak = mid;
                    break;
                }
                else {
                    lo = mid+1;
                }
            }
            else {
                hi = mid-1;
            }
        }
        if (peak == -1) {
            peak = lo;
        }
        // System.out.println(String.format("peak: %d", peak));
        //search left
        lo = 0;
        hi = peak;
        while (lo < hi) {
            int mid = lo - (lo - hi)/2;
            int val = getVal(mid);
            if (val == target) {
                return mid;
            }
            if (val < target) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        if (getVal(lo) == target) {
            return lo;
        }
        //search right
        lo = peak;
        hi = n-1;
        while (lo < hi) {
            int mid = lo - (lo - hi)/2;
            int val = getVal(mid);
            if (val == target) {
                return mid;
            }
            if (val < target) {
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        if (getVal(lo) == target) {
            return lo;
        }
        return -1;
    }
    public int getVal(int pos) {
        if (cache.containsKey(pos)) {
            return cache.get(pos);
        }
        else {
            int val = m.get(pos);
            cache.put(pos, val);
            return val;
        }
    }
}

/*
[1,2,3,4,5,3,1]
2
*/