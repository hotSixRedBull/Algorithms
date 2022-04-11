class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        ArrayDeque<Integer> q = new ArrayDeque();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                q.add(grid[i][j]);
            }
        }
        
        for (int i=0; i<k; i++) {
            q.addFirst(q.pollLast());
        }
        
        List<List<Integer>> list = new ArrayList();
        for (int i=0; i<grid.length; i++) {
            List<Integer> tmpList = new ArrayList();
            for (int j=0; j<grid[i].length; j++) {
                tmpList.add(q.pollFirst());
            }
            list.add(tmpList);
        }
        return list;
    }
}