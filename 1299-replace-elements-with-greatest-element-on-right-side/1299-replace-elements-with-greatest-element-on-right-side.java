class Solution {
    public int[] replaceElements(int[] arr) {
        int top = -1;
        int nextTop = 0;
        for (int i=arr.length-1; i>=0; i--) {
            nextTop = Math.max(top, arr[i]);
            arr[i] = top;
            top = nextTop;
        }
        return arr;
    }
}