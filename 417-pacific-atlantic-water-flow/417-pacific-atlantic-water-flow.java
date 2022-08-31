// saw solution
// totally started from wrong direction

class Solution {
    private static final int[][] DIRECTIONS = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private int numRows;
    private int numCols;
    private int[][] landHeights;
    
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // Check if input is empty
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        // Save initial values to parameters
        numRows = matrix.length;
        numCols = matrix[0].length;
        landHeights = matrix;
        
        // Setup each queue with cells adjacent to their respective ocean
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            pacificQueue.offer(new int[]{i, 0});
            atlanticQueue.offer(new int[]{i, numCols - 1});
        }
        for (int i = 0; i < numCols; i++) {
            pacificQueue.offer(new int[]{0, i});
            atlanticQueue.offer(new int[]{numRows - 1, i});
        }
        
        // Perform a BFS for each ocean to find all cells accessible by each ocean
        boolean[][] pacificReachable = bfs(pacificQueue);
        boolean[][] atlanticReachable = bfs(atlanticQueue);
        
        // Find all cells that can reach both oceans
        List<List<Integer>> commonCells = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (pacificReachable[i][j] && atlanticReachable[i][j]) {
                    commonCells.add(List.of(i, j));
                }
            }
        }
        return commonCells;
    }
    
    private boolean[][] bfs(Queue<int[]> queue) {
        boolean[][] reachable = new boolean[numRows][numCols];
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            // This cell is reachable, so mark it
            reachable[cell[0]][cell[1]] = true;
            for (int[] dir : DIRECTIONS) { // Check all 4 directions
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];
                // Check if new cell is within bounds
                if (newRow < 0 || newRow >= numRows || newCol < 0 || newCol >= numCols) {
                    continue;
                }
                // Check that the new cell hasn't already been visited
                if (reachable[newRow][newCol]) {
                    continue;
                }
                // Check that the new cell has a higher or equal height,
                // So that water can flow from the new cell to the old cell
                if (landHeights[newRow][newCol] < landHeights[cell[0]][cell[1]]) {
                    continue;
                }
                // If we've gotten this far, that means the new cell is reachable
                queue.offer(new int[]{newRow, newCol});
            }
        }
        return reachable;
    }
}

/*
class Solution {
    int[][] map;
    int[][] isUpperCache;
    int[][] isLowerCache;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList();
         map = heights;
        isUpperCache = new int[heights.length][heights[0].length];
        isLowerCache = new int[heights.length][heights[0].length];
        for (int r=0; r<map.length; r++) {
            for (int c=0; c<map[0].length; c++) {
                System.out.println(String.format("%d, %d", r,c));
                if (isUpper(r,c)
                   && isLower(r,c)) {
                    System.out.println("pass");
                    ans.add(new ArrayList(List.of(r,c)));
                }
            }
        }
        return ans;
    }
    
    public boolean isUpper(int r, int c) {
        System.out.println(String.format("^^%d, %d", r,c));
        if (r == 0
           || c == 0) {
            return true;
        }
        
        if (isUpperCache[r][c] != 0) {
            return isUpperCache[r][c] == 1;
        }
        
        boolean cacheAnswer = false;
        if (r > 0
           && map[r-1][c] <= map[r][c]) {
            cacheAnswer |= isUpper(r-1, c);
        }
        if (c > 0
           && map[r][c-1] <= map[r][c]) {
            cacheAnswer |= isUpper(r, c-1);
        }
        isUpperCache[r][c] = cacheAnswer == true ? 1 : -1;
        return isUpperCache[r][c] == 1;
    }
    
    public boolean isLower(int r, int c) {
        System.out.println(String.format("__%d, %d", r,c));
        if (r == map.length-1
           || c == map[0].length-1) {
            return true;
        }
        
        if (isLowerCache[r][c] != 0) {
            return isLowerCache[r][c] == 1;
        }
        boolean cacheAnswer = false;
        if (r < map.length-1
           && map[r+1][c] <= map[r][c]) {
            cacheAnswer |= isLower(r+1, c);
        }
        if (c < map[0].length-1
           && map[r][c+1] <= map[r][c]) {
            cacheAnswer |= isLower(r, c+1);
        }
        isLowerCache[r][c] = cacheAnswer == true ? 1 : -1;
        return isLowerCache[r][c] == 1;
    }
}

// [[10,10,10],[10,1,10],[10,10,10]]
// [[1,2,3],[8,9,4],[7,6,5]]
*/