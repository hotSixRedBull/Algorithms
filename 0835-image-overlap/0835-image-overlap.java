//saw solution 1
class Solution {
    /**
     *  Shift the matrix M in up-left and up-right directions 
     *    and count the ones in the overlapping zone.
     */
    protected int shiftAndCount(int xShift, int yShift, int[][] M, int[][] R) {
        int leftShiftCount = 0, rightShiftCount = 0;
        int rRow = 0;
        // count the cells of ones in the overlapping zone.
        for (int mRow = yShift; mRow < M.length; ++mRow) {
            int rCol = 0;
            for (int mCol = xShift; mCol < M.length; ++mCol) {
                if (M[mRow][mCol] == 1 && M[mRow][mCol] == R[rRow][rCol])
                    leftShiftCount += 1;
                if (M[mRow][rCol] == 1 && M[mRow][rCol] == R[rRow][mCol])
                    rightShiftCount += 1;
                rCol += 1;
            }
            rRow += 1;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }

    public int largestOverlap(int[][] A, int[][] B) {
        int maxOverlaps = 0;

        for (int yShift = 0; yShift < A.length; ++yShift)
            for (int xShift = 0; xShift < A.length; ++xShift) {
                // move the matrix A to the up-right and up-left directions.
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, A, B));
                // move the matrix B to the up-right and up-left directions, which is equivalent to moving A to the down-right and down-left directions 
                maxOverlaps = Math.max(maxOverlaps, shiftAndCount(xShift, yShift, B, A));
            }

        return maxOverlaps;
    }
}
/*
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int[][] i1 = buildLines(img1);
        int[][] i2 = buildLines(img2);
        
        int biggest = -1;
        //up n times
        for (int diff=0; diff<n; diff++) {
            int overlap = 0;
            for (int i=0; i<n; i++) {
                if (i+diff >= n) {
                    break;
                }
                if (i1[i+diff][0] == i2[i][0]) {
                    overlap += i1[i+diff][1];
                }
            }
            biggest = Math.max(biggest, overlap);
        }
        
        //down n times
        
        //left n times
        
        //right n times
        
        return biggest;
    }
    
    public int[][] buildLines(int[][] img) {
        int n = img.length;
        int[][] ret = new int[n][2];
        for (int r=0; r<n; r++) {
            int line = 0;
            int cnt = 0;
            for (int c=0; c<n; c++) {
                if (img[r][c] == 1) {
                    line += 1;
                    cnt++;
                }
                line <<= 1;
            }
            line >>>= 1;
            // System.out.println(String.format("%s became %s", Arrays.toString(img[r]), Integer.toString(line, 2)));
            ret[r][0] = line;
            ret[r][1] = cnt;
        }
        return ret;
    }
}
*/