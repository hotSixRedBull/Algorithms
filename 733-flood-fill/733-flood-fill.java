class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //BFS
        int M = image.length;
        int N = image[0].length;
        Queue<int[]> q = new ArrayDeque();
        q.add(new int[]{sr, sc});
        int target = image[sr][sc];
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        boolean[][] visited = new boolean[M][N];
        visited[sr][sc] = true;
        while (q.size() > 0) {
            int[] cur = q.poll();
            image[cur[0]][cur[1]] = newColor;
            for (int i=0; i<4; i++) {
                int nextR = cur[0]+dr[i];
                int nextC = cur[1]+dc[i];
                if (nextR >= 0
                   && nextC >= 0
                   && nextR < M
                   && nextC < N
                   && image[nextR][nextC] == target
                   && visited[nextR][nextC] == false) {
                    q.add(new int[]{nextR, nextC});
                    visited[nextR][nextC] = true;
                }
            }
        }
        return image;
    }
}