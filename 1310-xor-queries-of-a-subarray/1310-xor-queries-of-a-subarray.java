class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] acc = new int[arr.length+1];
        for (int i=1; i<=arr.length; i++) {
            acc[i] = acc[i-1]^arr[i-1];
        }
        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            result[i] = acc[queries[i][0]]^acc[queries[i][1]+1];
        }
        return result;
    }
}