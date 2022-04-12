class Solution {
    public void gameOfLife(int[][] board) {
        int[][] next = new int[board.length][board[0].length];
        
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[r].length; c++) {
                int nei = 0;
                if (r > 0) {
                    if (c > 0
                       && board[r-1][c-1] == 1) {
                        nei++;
                    }
                    if (board[r-1][c] == 1) {
                        nei++;
                    }
                    if (c < board[r].length-1
                       && board[r-1][c+1] == 1) {
                        nei++;
                    }
                }
                if (c > 0
                   && board[r][c-1] == 1) {
                    nei++;
                }
                if (c < board[r].length-1
                   && board[r][c+1] == 1) {
                    nei++;
                }
                if (r < board.length-1) { 
                    if (c > 0
                       && board[r+1][c-1] == 1) {
                        nei++;
                    }
                    if (board[r+1][c] == 1) {
                        nei++;
                    }
                    if (c < board[r].length-1
                       && board[r+1][c+1] == 1) {
                        nei++;
                    }
                }
                if (board[r][c] == 1) {
                    if (nei == 2 || nei == 3) {
                        next[r][c] = 1;
                    }
                    else {
                        next[r][c] = 0;
                    }
                }
                else if (nei == 3) {
                    next[r][c] = 1;
                }
                // System.out.println(String.format("(%d, %d): %d, nei: %d",r,c,next[r][c],nei));
            }
        }
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board[r].length; c++) {
                board[r][c] = next[r][c];
            }
        }
    }
}