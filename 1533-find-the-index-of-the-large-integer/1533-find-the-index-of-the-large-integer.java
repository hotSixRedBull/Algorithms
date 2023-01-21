/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        return recursive(reader, 0, reader.length()-1);
    }
    
    public int recursive(ArrayReader r, int start, int end) {
        if (start == end) {
            return start;
        }
        int len = end-start+1;
        if (len % 3 == 0) {
            int val = r.compareSub(start, start+len/3-1, start+len/3, start+len/3*2-1);
            if (val == 1) {
                return recursive(r, start, start+len/3-1);
            }
            else if (val == -1) {
                return recursive(r, start+len/3, start+len/3*2-1);
            }
            else {
                return recursive(r, start+len/3*2, end);
            }
        }
        else if (len % 2 == 0) {
            int val = r.compareSub(start, start+len/2-1, start+len/2, end);
            if (val == 1) {
                return recursive(r, start, start+len/2-1);
            }
            else {
                return recursive(r, start+len/2, end);
            }
        }
        else {
            int val = r.compareSub(start+1, start+len/2, start+len/2+1, end);
            if (val == 0) {
                return start;
            }
            else if (val == 1) {
                return recursive(r, start+1, start+len/2);
            }
            else {
                return recursive(r, start+len/2+1, end);
            }
        }
    }
}