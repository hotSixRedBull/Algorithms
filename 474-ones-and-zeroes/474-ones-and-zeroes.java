class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length][101][101];
        int[][] cnt = new int[strs.length][2];
        for (int i=0; i<strs.length; i++) {
            cnt[i] = count(strs[i]);
            // System.out.println(Arrays.toString(cnt[i]));
        }
        dp[0][cnt[0][0]][cnt[0][1]] = 1;
        for (int i=cnt[0][0]; i<=m; i++) {
            for (int j=cnt[0][1]; j<=n; j++) {
                dp[0][i][j] = 1;
            }
        }
        // for (int i=0; i<=m; i++) {
        //     System.out.println(Arrays.toString(dp[0][i]));
        // }
        for (int r=1; r<strs.length; r++) {
            int newM = cnt[r][0];
            int newN = cnt[r][1];
            // System.out.println(String.format("r: %d, newM: %d, newN: %d", r, newM, newN));
            for (int i=0; i<=m; i++) {
                for (int j=0; j<=n; j++) {
                    dp[r][i][j] = dp[r-1][i][j];
                }
            }
            for (int i=newM; i<=m; i++) {
                for (int j=newN; j<=n; j++) {
                    dp[r][i][j] = Math.max(dp[r][i][j], dp[r-1][i-newM][j-newN]+1);
                }
            }
            // for (int i=0; i<=m; i++) {
            //     System.out.println(Arrays.toString(dp[r][i]));
            // }
            // System.out.println("-----");
        }
        
        
        return dp[strs.length-1][m][n];
    }
    
    public int[] count(String s) {
        int[] ret = new int[2];
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '0') {
                ret[0]++;
            }
            else {
                ret[1]++;
            }
        }
        return ret;
    }
}