class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length == 1) {
            return false;
        }
        
        boolean isIncreasing = true;
        int increasingCnt = 0;
        
        for (int i=1; i<arr.length; i++) {
            if (arr[i] == arr[i-1]) {
                return false;
            }
            else if (arr[i] > arr[i-1]) {
                if (!isIncreasing) {
                    return false;
                }
                increasingCnt++;
            }
            else if (arr[i] < arr[i-1]) {
                if (increasingCnt == 0) {
                    return false;
                }
                isIncreasing = false;
            }
        }
        return isIncreasing == false;
    }
}