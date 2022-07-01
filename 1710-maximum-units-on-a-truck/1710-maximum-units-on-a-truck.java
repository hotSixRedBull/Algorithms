class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> b[1]-a[1]);
        int units = 0;
        for (int[] box : boxTypes) {
            if (truckSize == 0) {
                break;
            }
            int cnt = Math.min(truckSize, box[0]);
            truckSize -= cnt;
            units += cnt*box[1];
        }
        return units;
    }
}