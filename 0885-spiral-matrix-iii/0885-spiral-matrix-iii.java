class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        List<int[]> li = new ArrayList();
        int curR = rStart;
        int curC = cStart;
        int cnt = rows*cols;
        int radius = 1;
        int dir = 0; // 0: right, 1: down, 2: left, 3: up
        int radius_left = 1;
        while (cnt > 0) {
            if (isValid(curR, curC, rows, cols)) {
                cnt--;
                li.add(new int[]{curR, curC});
            }
            int[] next = move(curR, curC, dir);
            curR = next[0];
            curC = next[1];
            radius_left--;
            if (radius_left == 0) {
                if (dir == 1 
                    || dir == 3) {
                    radius++;
                }
                radius_left = radius;
                dir = dir == 3 ? 0 : dir+1;
            }
        }
        int[][] result = new int[li.size()][2];
        for (int i=0; i<li.size(); i++) {
            for (int j=0; j<2; j++) {
                result[i][j] = li.get(i)[j];
            }
        }
        return result;
    }
    
    public boolean isValid(int r, int c, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return false;
        }
        return true;
    }
    
    public int[] move(int r, int c, int dir) {
        int[] result = new int[]{r, c};
        if (dir == 0) {
            result[1]++;
        }
        else if (dir == 1) {
            result[0]++;
        }
        else if (dir == 2) {
            result[1]--;
        }
        else {
            result[0]--;
        }
        return result;
    }
}