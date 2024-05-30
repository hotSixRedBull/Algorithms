class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] acc = new int[n];
        acc[0] = arr[0];
        for (int i=1; i<n; i++) {
            acc[i] = acc[i-1]^arr[i];
        }
        
        int cnt = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                for (int k=j; k<n; k++) {
                    int a = i == 0 ? acc[j-1] : acc[j-1]^acc[i-1];
                    int b = acc[k]^acc[j-1];
                    if (a == b) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}