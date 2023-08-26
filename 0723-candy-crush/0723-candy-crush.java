class Solution {
    public int[][] candyCrush(int[][] board) {
        int removed = 0;
        int m = board.length;
        int n = board[0].length;
        
        do {
            removed = 0;
            boolean[][] remove = new boolean[m][n];
            print("start", board, remove);
            //horizontal
            for (int r=0; r<m; r++) {
                int cur = -1;
                int len = 1;
                for (int c=0; c<n; c++) {
                    if (board[r][c] == cur) {
                        len++;
                    }
                    else {
                        if (len >= 3) {
                            for (int i=0; i<len; i++) {
                                remove[r][c-1-i] = true;
                            }
                        }
                        cur = board[r][c] == 0 ? -1 : board[r][c];
                        len = 1;
                    }
                }
                if (len >= 3) {
                    for (int i=0; i<len; i++) {
                        remove[r][n-1-i] = true;
                    }
                }
            }
            print("after horizontal", board, remove);
            //vertical
            for (int c=0; c<n; c++) {
                int cur = -1;
                int len = 1;
                for (int r=0; r<m; r++) {
                    if (board[r][c] == cur) {
                        len++;
                    }
                    else {
                        if (len >= 3) {
                            for (int i=0; i<len; i++) {
                                remove[r-1-i][c] = true;
                            }
                        }
                        cur = board[r][c] == 0 ? -1 : board[r][c];
                        len = 1;
                    }
                }
                if (len >= 3) {
                    for (int i=0; i<len; i++) {
                        remove[m-1-i][c] = true;
                    }
                }
            }
            print("after vertical", board, remove);
            //remove
            for (int r=0; r<m; r++) {
                for (int c=0; c<n; c++) {
                    if (remove[r][c]) {
                        removed++;
                        board[r][c] = 0;
                    }
                }
            }
            print("after remove", board, remove);
            //drop
            for (int c=0; c<n; c++) {
                for (int r=m-1; r>=0; r--) {
                    if (board[r][c] == 0) {
                        boolean changed = false;
                        for (int r2=r-1; r2>=0; r2--) {
                            if (board[r2][c] != 0) {
                                changed = true;
                                board[r][c] = board[r2][c];
                                board[r2][c] = 0;
                                r--;
                            }
                        }
                        if (changed) {
                            r++;
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            print("after drop", board, remove);
        } while (removed > 0);
        
        return board;
    }
    
    public void print(String prefix, int[][] board, boolean[][] remove) {
        // System.out.println(prefix);
        // for (int r=0; r<board.length; r++) {
        //     System.out.println(Arrays.toString(board[r]));
        // }
        // for (int r=0; r<board.length; r++) {
        //     System.out.println(Arrays.toString(remove[r]));
        // }
    }
}