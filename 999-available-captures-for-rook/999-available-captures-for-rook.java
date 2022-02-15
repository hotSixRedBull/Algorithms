class Solution {
    public int numRookCaptures(char[][] board) {
        int rPos = 0;
        int cPos = 0;
        int cnt = 0;
        for (int r=0; r<board.length; r++) {
            for (int c=0; c<board.length; c++) {
                if (board[r][c] == 'R') {
                    rPos = r;
                    cPos = c;
                    break;
                }
            }
        }
        
        for (int r=rPos-1; r>=0; r--) {
            if (board[r][cPos] == 'B') {
                break;
            }
            else if (board[r][cPos] == 'p') {
                cnt++;
                break;
            }
        }
        
        for (int r=rPos+1; r<board.length; r++) {
            if (board[r][cPos] == 'B') {
                break;
            }
            else if (board[r][cPos] == 'p') {
                cnt++;
                break;
            }
        }
        
        for (int c=cPos-1; c>=0; c--) {
            if (board[rPos][c] == 'B') {
                break;
            }
            else if (board[rPos][c] == 'p') {
                cnt++;
                break;
            }
        }
        
        for (int c=cPos+1; c<board.length; c++) {
            if (board[rPos][c] == 'B') {
                break;
            }
            else if (board[rPos][c] == 'p') {
                cnt++;
                break;
            }
        }
        
        return cnt;
    }
}