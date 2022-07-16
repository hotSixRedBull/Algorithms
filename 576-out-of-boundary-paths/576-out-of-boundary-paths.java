// saw answer
// write myself
class Solution {
    int[] dr;
    int[] dc;
    int[][][] cache;
    int ans;
    public Solution() {
        ans = 0;
        dr = new int[]{-1,0,1,0};
        dc = new int[]{0,1,0,-1};
        cache = new int[51][51][51];
        for (int i=0; i<51; i++) {
            for (int j=0; j<51; j++) {
                Arrays.fill(cache[i][j], -1);
            }
        }
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow < 0
           || startColumn < 0
           || startRow == m
           || startColumn == n) {
            return 1;
        }
        if (maxMove == 0) {
            return 0;
        }
        if (cache[startRow][startColumn][maxMove] != -1) {
            return cache[startRow][startColumn][maxMove];
        }
        int localAns = 0;
        for (int i=0; i<4; i++) {
            int nr = startRow + dr[i];
            int nc = startColumn + dc[i];
            localAns += findPaths(m,n,maxMove-1,nr,nc);
            localAns %= 1_000_000_007;
        }
        cache[startRow][startColumn][maxMove] = localAns;
        return localAns;
    }
}