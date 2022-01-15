class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        // Arrays.sort(updates, new Comparator<int[]>() {
        //    @Override
        //     public int compare(int[] i1, int[] i2) {
        //         if (i1[0] == i2[0]) {
        //             return i1[1] > i2[1] ? 1 : -1;
        //         }
        //         return i1[0] > i2[0] ? 1 : -1;
        //     }
        // });
        // System.out.println(Arrays.toString(updates[2]));
        // return updates[0];
        int[] ans = new int[length];
        for (int[] update : updates) {
            for (int i=update[0]; i<=update[1]; i++) {
                ans[i] += update[2];
            }
        }
        return ans;
    }
}