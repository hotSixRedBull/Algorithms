class Solution {
    public int findKthPositive(int[] arr, int k) {
        int find = 1;
        int left = k;
        for (int i=0; i<arr.length; i++) {
            if (find < arr[i]) {
                int diff = arr[i]-find;
                if (diff < left) {
                    find = arr[i]+1;
                    left -= diff; 
                }
                else {
                    return find+left-1;
                }
            }
            else if (find == arr[i]) {
                find++;
            }
        }
        return find+left-1;
    }
}