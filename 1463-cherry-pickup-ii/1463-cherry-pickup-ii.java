class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                for (int k=0; k<grid[0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        if (0 == grid[0].length-1) {
            dp[0][0][grid[0].length-1] = grid[0][0];
        }
        else {
            dp[0][0][grid[0].length-1] = grid[0][0]+grid[0][grid[0].length-1];
        }
        
        int[] dc = new int[]{-1, 0, 1};
        for (int i=1; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                for (int k=0; k<grid[0].length; k++) {
                    int localMax = -1;
                    for (int c1=0; c1<3; c1++) {
                        int beforeC1 = j + dc[c1];
                        for (int c2=0; c2<3; c2++) {
                            int beforeC2 = k + dc[c2];
                            if (beforeC1 >= 0 && beforeC1 < grid[0].length
                               && beforeC2 >= 0 && beforeC2 < grid[0].length) {
                                localMax = Math.max(localMax, dp[i-1][beforeC1][beforeC2]);
                            }
                        }
                    }
                    if (localMax == -1) {
                        continue;
                    }
                    if (j == k) {
                        dp[i][j][k] = grid[i][j] + localMax;
                    }
                    else {
                        dp[i][j][k] = grid[i][j] + grid[i][k] + localMax;
                    }
                    max = Math.max(max, dp[i][j][k]);
                }
            }
        }
        // for (int i=0; i<grid.length; i++) {
        //     System.out.println(">>>"+i);
        //     for (int j=0; j<grid[0].length; j++) {
        //         System.out.println(Arrays.toString(dp[i][j]));
        //     }
        // }
        return max;
    }
}
/*
[
[0,8,7,10,9,10,0,9,6],
[8,7,10,8,7,4,9,6,10],
[8,1,1,5,1,5,5,1,2],
[9,4,10,8,8,1,9,5,0],
[4,3,6,10,9,2,4,8,10],
[7,3,2,8,3,3,5,9,8],
[1,2,6,5,6,2,0,10,0]
]
*/