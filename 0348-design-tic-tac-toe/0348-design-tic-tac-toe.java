class TicTacToe {
    int n;
    int[][] map;
    public TicTacToe(int n) {
        this.n = n;
        map = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        map[row][col] = player;
        int[] streak = new int[4];
        for (int i=0; i<n; i++) {
            if (map[row][i] == player) {
                streak[0]++;
                if (streak[0] == n) {
                    return player;
                }
            }
            if (map[i][col] == player) {
                streak[1]++;
                if (streak[1] == n) {
                    return player;
                }
            }
            if (map[i][i] == player) {
                streak[2]++;
                if (streak[2] == n) {
                    return player;
                }
            }
            if (map[i][n-1-i] == player) {
                streak[3]++;
                if (streak[3] == n) {
                    return player;
                }
            }
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */