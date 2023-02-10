class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        
        boolean[][] v = new boolean[n][n];
        List<int[]> li = new ArrayList();
        for(int r=0; r<n; r++) {
            for (int c=0; c<n; c++) {
                if (grid[r][c] == 1) {
                    li.add(new int[]{r,c});
                    v[r][c] = true;
                }
            }
        }
        
        List<int[]> nli = new ArrayList();
        int d=-1;
        if (li.size() == 0) {
            return d;
        }
        do {
            // System.out.println(String.format("d: %d", d));
            for (int[] cur : li) {
                int r = cur[0];
                int c = cur[1];
                // System.out.println(String.format("(%d,%d)", r,c));
                for (int i=0; i<4; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < 0 || nc < 0 || nr >= n || nc >= n || v[nr][nc]) {
                        continue;
                    }
                    v[nr][nc]=true;
                    nli.add(new int[]{nr, nc});
                }
            }
            li = nli;
            nli = new ArrayList();
            d++;
        } while(li.size() > 0);
        return d == 0 ? -1 : d;
    }
}