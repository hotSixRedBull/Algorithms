class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[] dr = new int[]{-2,-1,1,2,2,1,-1,-2};
        int[] dc = new int[]{1,2,2,1,-1,-2,-2,-1};
        double[][][] dp = new double[k+1][n][n];
        dp[0][row][column] = 1;
        for (int i=1; i<=k; i++) {
            for (int r=0; r<n; r++) {
                for (int c=0; c<n; c++) {
                    for (int s=0; s<8; s++) {
                        int nr = r+dr[s];
                        int nc = c+dc[s];
                        if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                            continue;
                        }
                        dp[i][r][c] += dp[i-1][nr][nc]/8;
                    }
                }
            }
        }
        
        double sum = 0;
        for (int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                sum += dp[k][r][c];
            }
        }
        return sum;
    }
}
//saw solution
/*
class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        int[] dr = new int[]{-2,-1,1,2,2,1,-1,-2};
        int[] dc = new int[]{1,2,2,1,-1,-2,-2,-1};
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{row, column, 0});
        int whole = 0;
        int succeed = 0;
        while (q.size() > 0) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int move = cur[2];
            if (move == k) {
                whole++;
                succeed++;
                continue;
            }
            for (int i=0; i<8; i++) {
                int nr = r+dr[i];
                int nc = c+dc[i];
                if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                    whole++;
                    continue;
                }
                q.add(new int[]{nr, nc, move+1});
            }
        }
        
        System.out.println(String.format("%d/%d", succeed, whole));
        
        if (k == 0) {
            return 1;
        }
        else {
            return (double)succeed/ (double)whole;
        }
    }
}
*/