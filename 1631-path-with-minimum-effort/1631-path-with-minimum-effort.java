//looked solution
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1000000;
        int result = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (dfsUtil(heights, mid)) {
                result = Math.min(result, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean dfsUtil(int[][] heights, int mid) {
        int row = heights.length;
        int col = heights[0].length;
        boolean visited[][] = new boolean[row][col];
        return canReachDestinaton(0, 0, heights, visited, row, col, mid);
    }

    boolean canReachDestinaton(int x, int y, int[][] heights,
                               boolean[][] visited, int row, int col, int mid) {
        if (x == row - 1 && y == col - 1) {
            return true;
        }
        visited[x][y] = true;
        for (int[] direction : directions) {
            int adjacentX = x + direction[0];
            int adjacentY = y + direction[1];
            if (isValidCell(adjacentX, adjacentY, row, col) && !visited[adjacentX][adjacentY]) {
                int currentDifference = Math.abs(heights[adjacentX][adjacentY] - heights[x][y]);
                if (currentDifference <= mid) {
                    if (canReachDestinaton(adjacentX, adjacentY, heights, visited, row, col, mid))
                        return true;
                }
            }
        }
        return false;
    }

    boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }
}