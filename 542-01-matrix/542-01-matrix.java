class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        if (M == 0) {
            return mat;
        }
        int[][] dist = new int[M][N];

        //First pass: check for left and top
        for (int i = 0; i < M; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE-10000);
            for (int j = 0; j < N; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                } else {
                    if (i > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        //Second pass: check for bottom and right
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i < M - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < N - 1)
                    dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
        return dist;
    }
}