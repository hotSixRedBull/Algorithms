class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        List<Integer> list = new ArrayList<>();
        while (pos1 < arr1.length && pos2 < arr2.length && pos3 < arr3.length) {
            if (arr1[pos1] == arr2[pos2] && arr2[pos2] == arr3[pos3]) {
                list.add(arr1[pos1]);
                pos1++;
                pos2++;
                pos3++;
            }
            else if (arr1[pos1] < arr2[pos2] && arr1[pos1] < arr3[pos3]) {
                pos1++;
            }
            else if (arr2[pos2] < arr1[pos1] && arr2[pos2] < arr3[pos3]) {
                pos2++;
            }
            else if (arr3[pos3] < arr1[pos1] && arr3[pos3] < arr2[pos2]) {
                pos3++;
            }
            else if (arr1[pos1] < arr3[pos3] && arr2[pos2] < arr3[pos3]) {
                pos1++;
                pos2++;
            }
            else if (arr1[pos1] < arr2[pos2] && arr3[pos3] < arr2[pos2]) {
                pos1++;
                pos3++;
            }
            else if (arr2[pos2] < arr1[pos1] && arr3[pos3] < arr1[pos1]) {
                pos2++;
                pos3++;
            }
        }
        return list;
    }
}