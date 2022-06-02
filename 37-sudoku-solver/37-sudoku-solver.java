class Solution {
   boolean isSolvable = false;
   int[][] rows = new int[9][10];
   int[][] cols = new int[9][10];
   int[][] boxes= new int[9][10];
   char[][] boardCpy;
  
   int getBoxIndex(int r, int c) {
    return r/3*3 + c/3;
  }
  
   boolean placeable(int r, int c, int d) {
    int boxIndex = getBoxIndex(r, c);
    return rows[r][d] == 0 && cols[c][d] == 0 && boxes[boxIndex][d] == 0;
  }
  
   void placeNumber(int r, int c, int d) {
    int boxIndex = getBoxIndex(r, c);
    rows[r][d]++;
    cols[c][d]++;
    boxes[boxIndex][d]++;
    boardCpy[r][c] = (char)(d+(int)'0');
  }
  
   void removeNumber(int r, int c, int d) {
    int boxIndex = getBoxIndex(r, c);
    rows[r][d]--;
    cols[c][d]--;
    boxes[boxIndex][d]--;
    boardCpy[r][c] = '.';
  }
  
   void placeNextNumber(int r, int c) {
    if (r == 8
       && c == 8) {
      isSolvable = true;
      return;
    }
    
    if (c == 8) {
      backtrack(r+1, 0);
    }
    else {
      backtrack(r,c+1);
    }
  }
  
   void backtrack(int r, int c) {
        if (boardCpy[r][c] == '.') {
          for (int num=1; num<=9; num++) {
            if (placeable(r,c,num)) {
              placeNumber(r,c,num);
              placeNextNumber(r,c);
              if (isSolvable) {
                return;
              }
              removeNumber(r,c,num);
            }
          }
        }
        else {
          placeNextNumber(r,c);
        }
  }
    public void solveSudoku(char[][] board) {
        isSolvable = false;
        boardCpy = board;
        for (int r=0; r<9; r++) {
          for (int c=0; c<9; c++) {
            if (board[r][c] != '.') {
              placeNumber(r, c, (int)board[r][c]-(int)'0');
            }
          }
        }
        backtrack(0,0);
        // return isSolvable;
    }
    
    
}