class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        List<List<Set<Character>>> squares = new ArrayList();
        for (int i=0; i<3; i++) {
            squares.add(new ArrayList());
            for (int j=0; j<3; j++) {
                List<Set<Character>> sqlist = squares.get(i);
                Set<Character> square = new HashSet();
                int startR = i*3;
                int startC = j*3;
                for (int squareR = startR; squareR<startR+3; squareR++) {
                    for (int squareC = startC; squareC<startC+3; squareC++) {
                        if (board[squareR][squareC] == '.') {
                            continue;
                        }
                        else if (square.contains(board[squareR][squareC])) {
                            return false;
                        }
                        square.add(board[squareR][squareC]);
                    }
                }
                sqlist.add(square);
            }
        }
        List<HashSet<Character>> cols = new ArrayList();
        for (int c=0; c<n; c++) {
            cols.add(new HashSet());
            for (int r=0; r<m; r++) {
                if (board[r][c] == '.') {
                    continue;
                }
                else if (cols.get(c).contains(board[r][c])) {
                    return false;
                }
                cols.get(c).add(board[r][c]);
            }
        }
        List<HashSet<Character>> rows = new ArrayList();
        for (int r=0; r<m; r++) {
            rows.add(new HashSet());
            for (int c=0; c<n; c++) {
                if (board[r][c] == '.') {
                    continue;
                }
                else if (rows.get(r).contains(board[r][c])) {
                    return false;
                }
                rows.get(r).add(board[r][c]);
            }
        }
        // for (int r=0; r<m; r++) {
        //     for (int c=0; c<n; c++) {
        //         int rowNo = (int)Math.floor(r/3);
        //         int colNo = (int)Math.floor(c/3);
        //         Set<Character> square = new HashSet(squares.get(rowNo).get(colNo));
        //         Set<Character> row = new HashSet(rows.get(r));
        //         Set<Character> col = new HashSet(cols.get(c));
        //         Set<Character> squareRow = new HashSet();
        //         Set<Character> squareCol = new HashSet();
        //         int rowStandard = rowNo*3;
        //         int colStandard = colNo*3;
        //         squareRow.add(board[r][c]);
        //         squareCol.add(board[r][c]);
        //         if (rowStandard == r) {
        //             squareCol.add(board[r+1][c]);
        //             squareCol.add(board[r+2][c]);
        //             if (colStandard == c) {
        //                 squareRow.add(board[r][c+1]);
        //                 squareRow.add(board[r][c+2]);
        //             }
        //             else if (colStandard+1 == c) {
        //                 squareRow.add(board[r][c-1]);
        //                 squareRow.add(board[r][c+1]);
        //             }
        //             else {
        //                 squareRow.add(board[r][c-2]);
        //                 squareRow.add(board[r][c-1]);
        //             }
        //         }
        //         else if (rowStandard+1 == r) {
        //             squareCol.add(board[r-1][c]);
        //             squareCol.add(board[r+1][c]);
        //             if (colStandard == c) {
        //                 squareRow.add(board[r][c+1]);
        //                 squareRow.add(board[r][c+2]);
        //             }
        //             else if (colStandard+1 == c) {
        //                 squareRow.add(board[r][c-1]);
        //                 squareRow.add(board[r][c+1]);
        //             }
        //             else {
        //                 squareRow.add(board[r][c-2]);
        //                 squareRow.add(board[r][c-1]);
        //             }
        //         }
        //         else {
        //             squareCol.add(board[r-2][c]);
        //             squareCol.add(board[r-1][c]);
        //             if (colStandard == c) {
        //                 squareRow.add(board[r][c+1]);
        //                 squareRow.add(board[r][c+2]);
        //             }
        //             else if (colStandard+1 == c) {
        //                 squareRow.add(board[r][c-1]);
        //                 squareRow.add(board[r][c+1]);
        //             }
        //             else {
        //                 squareRow.add(board[r][c-2]);
        //                 squareRow.add(board[r][c-1]);
        //             }
        //         }
        //         square.removeAll(squareRow);
        //         square.removeAll(squareCol);
        //         row.remove(board[r][c]);
        //         col.remove(board[r][c]);
        //         System.out.println(">>>");
        //         System.out.println(square);
        //         System.out.println(row);
        //         System.out.println(col);
        //         if (Collections.disjoint(square, row) == false
        //         || Collections.disjoint(row, col) == false
        //         || Collections.disjoint(col, square) == false) {
        //             return false;
        //         }
        //     }
        // }
        return true;
    }
}