class Solution {
    public int minSwaps(int[] data) {
        if (data.length == 1) {
            return 0;
        }
        int cnt = 0;
        int componentCnt = 0;
        boolean isComponent = false;
        for (int i=0; i<data.length; i++) {
            if (data[i] == 1) {
                cnt++;
                if (!isComponent) {
                    componentCnt++;
                    isComponent = false;
                }
            }
            else {
                isComponent = false;
            }
        }
        if (cnt == 1 || componentCnt == 1) {
            return 0;
        }
        // sliding window of size cnt;
        int cntZero = 0;
        int min = cnt;
        for (int i=0; i<cnt; i++) {
            if (data[i] == 0) {
                cntZero++;
            }
        }
        min = Math.min(min, cntZero);
        for (int i=cnt; i<data.length; i++) {
            if (data[i] == 1
               && data[i-cnt] == 0) {
                cntZero--;
            }
            else if (data[i] == 0
                    && data[i-cnt] == 1) {
                cntZero++;
            }
            min = Math.min(min, cntZero);
        }
        return min;
    }
}