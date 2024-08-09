class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        for (int r=0; r<m-2; r++) {
            for (int c=0; c<n-2; c++) {
                boolean isUnique = true;
                Set<Integer> set = new HashSet();
                for (int i=0; i<3; i++) {
                    for (int j=0; j<3; j++) {
                        if (set.contains(grid[r+i][c+j])
                           || grid[r+i][c+j] > 9
                           || grid[r+i][c+j] < 1) {
                            isUnique = false;
                            break;
                        }
                        set.add(grid[r+i][c+j]);
                    }
                    if (!isUnique) {
                        break;
                    }
                }
                if (!isUnique) {
                    continue;
                }
                
                boolean isValid = true;
                int rowSum = grid[r][c] + grid[r][c+1] + grid[r][c+2];
                for (int i=1; i<3; i++) {
                    int newRowSum = grid[r+i][c] + grid[r+i][c+1] + grid[r+i][c+2];
                    if (rowSum != newRowSum) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) {
                    continue;
                }
                int colSum = grid[r][c] + grid[r+1][c] + grid[r+2][c];
                if (colSum != rowSum) {
                    continue;
                }
                for (int i=1; i<3; i++) {
                    int newColSum = grid[r][c+i] + grid[r+1][c+i] + grid[r+2][c+i];
                    if (colSum != newColSum) {
                        isValid = false;
                        break;
                    }
                }
                if (!isValid) {
                    continue;
                }
                int diagSum1 = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
                int diagSum2 = grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
                if (colSum != diagSum1) {
                    continue;
                }
                if (diagSum1 != diagSum2) {
                    continue;
                }
                cnt++;
            }
        }
        return cnt;
    }
}