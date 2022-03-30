class Solution {
    private int R, C;

    private int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maximumMinimumPath(int[][] grid) {
        R = grid.length;
         C = grid[0].length;
        Queue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(grid[b[0]][b[1]], grid[a[0]][a[1]]));
              
        boolean[][] visited = new boolean[R][C];

        pq.offer(new int[] {0, 0});
        visited[0][0] = true;

        int ans = grid[0][0];

        while (!pq.isEmpty()) {
            int[] curGrid = pq.poll();
            int curRow = curGrid[0], curCol = curGrid[1];

            ans = Math.min(ans, grid[curRow][curCol]);

            if (curRow == R - 1 && curCol == C - 1) {
                break;
            }
            for (int[] dir : dirs) {
                int newRow = curRow + dir[0], newCol = curCol + dir[1];

                if (newRow >= 0 && newRow < R && newCol >= 0 && newCol < C 
                    && !visited[newRow][newCol]) {
                    pq.offer(new int[] {newRow, newCol});
                    visited[newRow][newCol] = true;
                } 
            }
        }

        return ans;        
    }
}