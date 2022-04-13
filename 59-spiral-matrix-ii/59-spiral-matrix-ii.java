class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        matrix[0][0] = 1;
        if (n == 1) {
            return matrix;
        }
        
        int r = 0;
        int c = 1;
        int cur = 2;
        int dir = 0;
        int[] dirCnt = new int[4];
        while (cur < n*n) {
            // System.out.println(String.format("r: %d, c: %d, cur: %d",r,c,cur));
            int end = dirCnt[(dir+1)%4];
            if (dir == 0) {
                for (int i=c; i<n-end; i++) {
                    matrix[r][i] = cur++;
                }
                r = r+1;
                c = n-end-1;
            }
            else if (dir == 1) {
                for (int i=r; i<n-end; i++) {
                    matrix[i][c] = cur++;
                }
                r = n-end-1;
                c = c-1;
            }
            else if (dir == 2) {
                for (int i=c; i>=end; i--) {
                    matrix[r][i] = cur++;
                }
                r = r-1;
                c = end;
            }
            else if (dir == 3) {
                for (int i=r; i>=end; i--) {
                    matrix[i][c] = cur++;
                }
                r = end;
                c = c+1;
            }
            dirCnt[dir]++;
            dir = (dir+1)%4;
        }
        matrix[r][c] = cur;
        return matrix;
    }
}