//TLE
//saw solution
class Solution {

    public long maxPoints(int[][] points) {
        int cols = points[0].length;
        long[] currentRow = new long[cols], previousRow = new long[cols];

        for (int[] row : points) {
            // runningMax holds the maximum value generated in the previous iteration of each loop
            long runningMax = 0;

            // Left to right pass
            for (int col = 0; col < cols; ++col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = runningMax;
            }

            runningMax = 0;
            // Right to left pass
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = Math.max(currentRow[col], runningMax) +
                row[col];
            }

            // Update previousRow for next iteration
            previousRow = currentRow;
        }

        // Find maximum points in the last row
        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }

        return maxPoints;
    }
}
/*
class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[][] cache = new long[m][n];
        
        for (int c=0; c<n; c++) {
            cache[0][c] = points[0][c];
        }
        
        for (int r=1; r<m; r++) {
            for (int c=0; c<n; c++) {
                for (int c2=0; c2<n; c2++) {
                    cache[r][c] = Math.max(cache[r][c], cache[r-1][c2]-(int)Math.abs(c2-c));
                }
                cache[r][c] += points[r][c];
            }
            // System.out.println(Arrays.toString(cache[r]));
        }
        
        long max = 0;
        for (int c=0; c<n; c++) {
            max = Math.max(max, cache[m-1][c]);
        }
        return max;
    }
}
*/