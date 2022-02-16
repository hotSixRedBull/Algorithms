class Solution {
    public int numSpecial(int[][] mat) {
        int cnt = 0;
        for (int r=0; r<mat.length; r++) {
            for (int c=0; c<mat[r].length; c++) {
                if (mat[r][c] == 1) {
                    boolean isSpecial = true;
                    for (int i=0; i<r; i++) {
                        if (mat[i][c] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    if (!isSpecial) {
                        break;
                    }
                    for (int i=r+1; i<mat.length; i++) {
                        if (mat[i][c] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    if (!isSpecial) {
                        break;
                    }
                    for (int i=0; i<c; i++) {
                        if (mat[r][i] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    if (!isSpecial) {
                        break;
                    }
                    for (int i=c+1; i<mat[r].length; i++) {
                        if (mat[r][i] == 1) {
                            isSpecial = false;
                            break;
                        }
                    }
                    if (!isSpecial) {
                        break;
                    }
                    if (isSpecial) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}