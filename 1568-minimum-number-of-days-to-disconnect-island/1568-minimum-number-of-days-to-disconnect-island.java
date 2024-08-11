//saw solution
//TLE
class Solution {

    // Directions for adjacent cells: right, down, left, up
    private static final int[][] DIRECTIONS = {
        { 0, 1 },
        { 1, 0 },
        { 0, -1 },
        { -1, 0 },
    };

    public int minDays(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        ArticulationPointInfo apInfo = new ArticulationPointInfo(false, 0);
        int landCells = 0, islandCount = 0;

        // Arrays to store information for each cell
        int[][] discoveryTime = new int[rows][cols]; // Time when a cell is first discovered
        int[][] lowestReachable = new int[rows][cols]; // Lowest discovery time reachable from the subtree rooted at
        // this cell
        int[][] parentCell = new int[rows][cols]; // Parent of each cell in DFS tree

        // Initialize arrays with default values
        for (int i = 0; i < rows; i++) {
            Arrays.fill(discoveryTime[i], -1);
            Arrays.fill(lowestReachable[i], -1);
            Arrays.fill(parentCell[i], -1);
        }

        // Traverse the grid to find islands and articulation points
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    landCells++;
                    if (discoveryTime[i][j] == -1) { // If not yet visited
                        // Start DFS for a new island
                        findArticulationPoints(
                            grid,
                            i,
                            j,
                            discoveryTime,
                            lowestReachable,
                            parentCell,
                            apInfo
                        );
                        islandCount++;
                    }
                }
            }
        }

        // Determine the minimum number of days to disconnect the grid
        if (islandCount == 0 || islandCount >= 2) return 0; // Already disconnected or no land
        if (landCells == 1) return 1; // Only one land cell
        if (apInfo.hasArticulationPoint) return 1; // An articulation point exists
        return 2; // Need to remove any two land cells
    }

    private void findArticulationPoints(
        int[][] grid,
        int row,
        int col,
        int[][] discoveryTime,
        int[][] lowestReachable,
        int[][] parentCell,
        ArticulationPointInfo apInfo
    ) {
        int rows = grid.length, cols = grid[0].length;
        discoveryTime[row][col] = apInfo.time;
        apInfo.time++;
        lowestReachable[row][col] = discoveryTime[row][col];
        int children = 0;

        // Explore all adjacent cells
        for (int[] direction : DIRECTIONS) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (isValidLandCell(grid, newRow, newCol)) {
                if (discoveryTime[newRow][newCol] == -1) {
                    children++;
                    parentCell[newRow][newCol] = row * cols + col; // Set parent
                    findArticulationPoints(
                        grid,
                        newRow,
                        newCol,
                        discoveryTime,
                        lowestReachable,
                        parentCell,
                        apInfo
                    );

                    // Update lowest reachable time
                    lowestReachable[row][col] = Math.min(
                        lowestReachable[row][col],
                        lowestReachable[newRow][newCol]
                    );

                    // Check for articulation point condition
                    if (
                        lowestReachable[newRow][newCol] >=
                            discoveryTime[row][col] &&
                        parentCell[row][col] != -1
                    ) {
                        apInfo.hasArticulationPoint = true;
                    }
                } else if (newRow * cols + newCol != parentCell[row][col]) {
                    // Update lowest reachable time for back edge
                    lowestReachable[row][col] = Math.min(
                        lowestReachable[row][col],
                        discoveryTime[newRow][newCol]
                    );
                }
            }
        }

        // Root of DFS tree is an articulation point if it has more than one child
        if (parentCell[row][col] == -1 && children > 1) {
            apInfo.hasArticulationPoint = true;
        }
    }

    // Check if the given cell is a valid land cell
    private boolean isValidLandCell(int[][] grid, int row, int col) {
        int rows = grid.length, cols = grid[0].length;
        return (
            row >= 0 &&
            col >= 0 &&
            row < rows &&
            col < cols &&
            grid[row][col] == 1
        );
    }

    private class ArticulationPointInfo {

        boolean hasArticulationPoint;
        int time;

        ArticulationPointInfo(boolean hasArticulationPoint, int time) {
            this.hasArticulationPoint = hasArticulationPoint;
            this.time = time;
        }
    }
}
/*
class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int cnt = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b)-> a[2]-b[2]);
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 1) {
                    cnt++;
                    int nei = 0;
                    for (int i=0; i<4; i++) {
                        int nr = r+dr[i];
                        int nc = c+dc[i];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                            continue;
                        }
                        if (grid[nr][nc] == 1) {
                            nei++;
                        }
                    }
                    if (nei == 0) {
                        return 0;
                    }
                    pq.add(new int[]{r, c, nei});
                }
            }
        }
        if (cnt == 2) {
            return 2;
        }
        else {
            int min = pq.peek()[2];
            for (int i=1; i<min; i++) {
                if (disconnect(grid, i, m, n)) {
                    return i;
                }
            }
            return min;
        }
    }
    public boolean disconnect(int[][] grid, int cnt, int m, int n) {
        if (cnt < 0) {
            return false;
        }
        if (cnt == 0) {
            //check disconnect
            return count_islands(grid, m, n) != 1;
        }
        //remove one and call disconnect(grid, cnt-1)
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 1) {
                    grid[r][c] = 0;
                    if (disconnect(grid, cnt-1, m, n)) {
                        return true;
                    }
                    grid[r][c] = 1;
                }
            }
        }
        return false;
    }
    
    public int count_islands(int[][] grid, int m, int n) {
        int islands = 0;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 1) {
                    islands++;
                    Queue<int[]> q = new ArrayDeque();
                    q.add(new int[]{r,c});
                    grid[r][c] = -1;
                    int[] dr = new int[]{-1,0,1,0};
                    int[] dc = new int[]{0,1,0,-1};
                    while (q.size() > 0) {
                        int[] cur = q.poll();
                        for (int i=0; i<4; i++) {
                            int nr = cur[0]+dr[i];
                            int nc = cur[1]+dc[i];
                            if (nr < 0 || nr >= m || nc < 0 || nc >=n
                               || grid[nr][nc] != 1) {
                                continue;
                            }
                            q.add(new int[]{nr, nc});
                        }
                    }
                }
            }
        }
        
        // recover
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == -1) {
                    grid[r][c] = 1;
                }
            }
        }
        
        //return result
        return islands;
    }
}

/*
[[0,1,1,0],[0,1,1,0],[0,0,0,0]]
[[1,1]]
[[1,1,1,1],[1,1,1,1],[1,1,1,1]]
[[1,1,1,1],[1,1,1,1],[0,0,0,0]]
[[1,1,1,1],[1,1,1,1],[0,0,0,1]]
[[1,1,0,0],[0,1,1,0],[0,0,1,1]]
[[1,0,1,0]]
[[1,1,0,1,1],[1,1,1,1,1],[1,1,0,1,1],[1,1,0,1,1]]
[[1,1,0,1,1],[1,1,1,1,1],[1,1,0,1,1],[1,1,1,1,1]]
*/