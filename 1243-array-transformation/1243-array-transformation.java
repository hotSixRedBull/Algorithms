class Solution {
    public List<Integer> transformArray(int[] arr) {
        boolean changed = true;
        while (changed) {
            changed = false;
            int[] newArr = Arrays.copyOf(arr, arr.length);
            for (int i=1; i<arr.length-1; i++) {
                if (arr[i] < arr[i-1]
                   && arr[i] < arr[i+1]) {
                    newArr[i]++;
                    changed = true;
                }
                else if (arr[i] > arr[i-1]
                        && arr[i] > arr[i+1]) {
                    newArr[i]--;
                    changed = true;
                }
            }
            arr = newArr;
        }
        Integer[] convertedArr = new Integer[arr.length];
        for (int i=0; i<arr.length; i++) {
            convertedArr[i] = arr[i];
        }
        return Arrays.asList(convertedArr);
    }
}