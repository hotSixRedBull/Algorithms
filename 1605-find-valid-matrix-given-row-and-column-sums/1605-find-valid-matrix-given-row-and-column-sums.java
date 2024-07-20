//saw solution
class Solution {

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int N = rowSum.length;
        int M = colSum.length;

        int[] currRowSum = new int[N];
        int[] currColSum = new int[M];

        int[][] origMatrix = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                origMatrix[i][j] = Math.min(
                    rowSum[i] - currRowSum[i],
                    colSum[j] - currColSum[j]
                );

                currRowSum[i] += origMatrix[i][j];
                currColSum[j] += origMatrix[i][j];
            }
        }
        return origMatrix;
    }
}
/*
class Solution {
    int[] rs;
    int[] cs;
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        rs = rowSum;
        cs = colSum;
        
        int m = rowSum.length;
        int n = colSum.length;
        int[][] ans = new int[m][n];
        build_ans(ans, 0, 0);
        return ans;
    }
    public boolean build_ans(int[][] ans, int r, int c) {
        //check csum
        int csum = 0;
        for (int i=0; i<ans.length; i++) {
            csum += ans[i][c];
        }
        //check rsum
        int rsum = 0;
        for (int i=0; i<c; i++) {
            rsum += ans[r][i];
        }
        if (r == ans.length-1) {
            if (cs[c] < csum) {
                return false;
            }
            if (c == ans[0].length-1) {
                if (cs[c] < csum
                   || rs[r] < rsum
                   || csum - cs[c] != rsum - rs[r]) {
                    return false;
                }
                else {
                    ans[r][c] = csum - cs[c];
                    return true;
                }
            }
            else {
                ans[r][c] = cs[c]-csum;
                if (build_ans(ans, r, c+1)) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        else {
            if (c == ans[0].length-1) {
                if (rs[r] < rsum) {
                    return false;
                }
                ans[r][c] = rs[r] - rsum;
                if (build_ans(ans, r+1, 0)) {
                    return true;
                }
                else {
                    return false;
                }
            }
            else {
                int min = Math.min(rs[r]-rsum, cs[c]-csum);
                for (int i=0; i<=min; i++) {
                    ans[r][c] = i;
                    if (build_ans(ans, r, c+1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
*/