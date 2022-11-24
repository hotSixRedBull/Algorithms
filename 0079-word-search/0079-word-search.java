// saw solution but wrote code on my own
class Solution {
    char[][] b;
    int[] dr;
    int[] dc;
    int m;
    int n;
    String w;

    public boolean exist(char[][] board, String word) {
        b = board;
        dr = new int[]{-1,0,1,0};
        dc = new int[]{0,1,0,-1};
        m = board.length;
        n = board[0].length;
        w = word;

        boolean ret = false;
        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
                if (board[r][c] == word.charAt(0)) {
                    ret |= backtrack(r, c, 0);
                }
            }
        }
        return ret;
    }

    public boolean backtrack(int r, int c, int pos) {
        if (pos == w.length()-1) {
            return true;
        }
        b[r][c] = '#';
        for (int i=0; i<4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];
            if (nr < 0
            || nc < 0
            || nr >= m
            || nc >= n
            || b[nr][nc] != w.charAt(pos+1)) {
                continue;
            }
            boolean ret = backtrack(nr, nc, pos+1);
            if (ret) {
                return true;
            }
        }
        b[r][c] = w.charAt(pos);
        return false;
    }
}