class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        for (int loop=0; loop<k; loop++) {
            int last = grid[grid.length-1][grid[0].length-1];
            for (int i=grid.length-1; i>=0; i--) {
                for (int j=grid[0].length-1; j>=0; j--) {
                    if (j == 0) {
                        if (i != 0) {
                            grid[i][0] = grid[i-1][grid[0].length-1];
                        }
                        else {
                            grid[0][0] = last;
                        }
                    }
                    else {
                        grid[i][j] = grid[i][j-1];
                    }
                }
            }
        }
        List<List<Integer>> list = new ArrayList();
        for (int i=0; i<grid.length; i++) {
            List<Integer> tmpList = new ArrayList();
            for (int j=0; j<grid[i].length; j++) {
                tmpList.add(grid[i][j]);
            }
            list.add(tmpList);
        }
        return list;
    }
}