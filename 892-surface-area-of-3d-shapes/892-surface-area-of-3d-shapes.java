class Solution {
    public int surfaceArea(int[][] grid) {
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        int ans = 0;
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid.length; c++) {
                if (grid[r][c] == 0) {
                    continue;
                }
                int allSurface = 2 + grid[r][c]*4;
                for (int i=0; i<4; i++) {
                    int nextR = r+dr[i];
                    int nextC = c+dc[i];
                    if (nextR >= 0 && nextC >= 0 && nextR < grid.length && nextC < grid.length) {
                        if (grid[nextR][nextC] >= grid[r][c]) {
                            allSurface -= grid[r][c];
                        }
                        else {
                            allSurface -= grid[nextR][nextC];
                        }
                    }
                }
                // System.out.println("surface on ["+r+","+c+"], "+grid[r][c]+" is "+allSurface);
                ans += allSurface;
            }
        }
        // System.out.println("<<end>>");
        return ans;
    }
}

/*

34 - 8 (아래위) = 26
- 2 (1부분) = 24
- 5 (2부분) = 19
- 8 (3부분) = 11
- 11 ()
*/