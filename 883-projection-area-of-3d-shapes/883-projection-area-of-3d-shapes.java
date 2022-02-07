class Solution {
    public int projectionArea(int[][] grid) {
        int top=0, front=0, side=0;
        int[] maxFront = new int[grid.length];
        int[] maxSide = new int[grid.length];
        for (int r=0; r<grid.length; r++) {
            int localMaxFront = 0;
            for (int c=0; c<grid[r].length; c++) {
                if (grid[r][c] != 0) {
                    top++;
                }
                localMaxFront = Math.max(localMaxFront, grid[r][c]);
            }
            maxFront[r] = localMaxFront;
        }
        
        
        for (int c=0; c<grid.length; c++) {
            int localMaxSide = 0;
            for (int r=0; r<grid.length; r++) {
                localMaxSide = Math.max(localMaxSide, grid[r][c]);
            }
            maxSide[c] = localMaxSide;
        }
        
        for (int num : maxFront) {
            front += num;
        }
        
        for (int num : maxSide) {
            side += num;
        }
        
        return top+front+side;
    }
}