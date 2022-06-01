class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Integer>[] rows = new HashMap[9];
        Map<Character, Integer>[] cols = new HashMap[9];
        Map<Character, Integer>[] boxes = new HashMap[9];
        for (int i=0; i<9; i++) {
            rows[i] = new HashMap();
            cols[i] = new HashMap();   
            boxes[i] = new HashMap();   
        }
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    if (rows[i].containsKey(board[i][j])) {
                        // System.out.println("1");
                        return false;
                    }
                    else {
                        rows[i].put(board[i][j], 1);
                    }
                }
            }
            for (int j=0; j<9; j++) {
                if (board[i][j] != '.') {
                    if (cols[j].containsKey(board[i][j])) {
                        // System.out.println("2");
                        return false;
                    }
                    else {
                        cols[j].put(board[i][j], 1);
                    }
                }
            }
            int boxR = i/3;
            int boxC = i%3;
            for (int offsetR=0; offsetR<3; offsetR++) {
                for (int offsetC=0; offsetC<3; offsetC++) {
                    if (board[boxR*3+offsetR][boxC*3+offsetC] != '.') {   
                        if (boxes[i].containsKey(board[boxR*3+offsetR][boxC*3+offsetC])) {
                        // System.out.println("3");
                            return false;
                        }
                        else {
                            boxes[i].put(board[boxR*3+offsetR][boxC*3+offsetC], 1);
                        }
                    }
                }
            }
        }
        return true;
    }
}