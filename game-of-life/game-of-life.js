/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function(board) {
    let diff = [[-1,-1], [-1, 0], [-1, 1], [ 0,-1], [ 0, 1], [ 1,-1], [ 1, 0], [ 1, 1]];
    let boardFixed = [];
    for (let i=0; i<board.length; i++) {
        boardFixed.push(board[i].slice());
    }
    function countLives(coor) {
        let cnt = 0;
        for (let i=0; i<diff.length; i++) {
            let row = coor[0]+diff[i][0];
            let col = coor[1]+diff[i][1];
            if (row >= 0 
                && row < boardFixed.length 
                && col >= 0 
                && col < boardFixed[0].length 
                && boardFixed[row][col] == 1) {
                cnt++;
            }
        }
        //console.log(`cnt on ${coor} is ${cnt}`);
        return cnt;
    }
    for (let r=0; r<board.length; r++) {
        for (let c=0; c<board[0].length; c++) {
            let cnt = countLives([r,c]);
            if (cnt < 2 || cnt > 3) {
                board[r][c] = 0;
            }
            else if (cnt == 3) {
                board[r][c] = 1;
            }
        }
    }
    return board;
};