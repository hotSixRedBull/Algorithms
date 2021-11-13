/**
 * @param {character[][]} board
 * @param {number[]} click
 * @return {character[][]}
 */
var updateBoard = function(board, click) {
    let diff = [[-1, 0], [-1, 1], [0, 1], [1, 1], [1, 0], [1, -1], [0, -1], [-1, -1]];
    let visited = {};
    function countMine(coor) {
        let cnt = 0;
        for (let i=0; i < 8; i++) {
            let row = coor[0]+diff[i][0];
            let col = coor[1]+diff[i][1];
            if (row >= 0 && col >= 0 && row < board.length && col < board[0].length) {
                if (board[row][col] == 'X' || board[row][col] == 'M') {
                    cnt++;
                }
            }
        }
        return cnt;
    }
    let stk = [click];
    while (stk.length > 0) {
        let cur = stk.pop();
        //console.log('cur', cur);
        if (board[cur[0]][cur[1]] == 'M') {
            board[cur[0]][cur[1]] = 'X';
        }
        else {
            let mineCnt = countMine(cur);
            //console.log('mineCnt', mineCnt);
            if (mineCnt == 0) {
                board[cur[0]][cur[1]] = 'B';
                for (let i=0; i < 8; i++) {
                    let row = cur[0]+diff[i][0];
                    let col = cur[1]+diff[i][1];
                    if (row >= 0 && col >= 0 && row < board.length && col < board[0].length) {
                        if (board[row][col] != 'B' 
                            && board[row][col] != 'X' 
                            && board[row][col] != 'M'
                            && visited[`${row},${col}`] == undefined) {
                            visited[`${row},${col}`] = true;
                            stk.push([row, col]);
                        }
                    }
                }
            }
            else {
                board[cur[0]][cur[1]] = String(mineCnt);
            }
        }
    }
    return board;
};