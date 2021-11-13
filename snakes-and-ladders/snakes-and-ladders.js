/**
 * @param {number[][]} board
 * @return {number}
 */
var snakesAndLadders = function(board) {
    let height = board.length;
    let width = height;
    
    function chkCoor(pos) {
        let row = height - 1 - Math.floor((pos-1)/height);
        let col = (height-1-row)%2 == 1 ? width - 1 - (pos-1)%width : (pos-1)%width;
        //console.log(`chkCoor(${pos}) : [${row},${col}]`)
        return board[row][col];
    }
    
    let q = [[1, 0]]; //second element is level;
    let front = 0;
    let visited = {};
    while (front < q.length) {
        let cur = q[front++];
        //console.log('cur', cur);
        curPos = cur[0];
        curLevel = cur[1];
        let boardValue = chkCoor(curPos);
        if (boardValue != -1) {
            curPos = boardValue;
        }
        if (curPos == width*height) {
            return curLevel;
        }
        let diceMax = Math.min(height*width+1, curPos+7);
        //console.log('diceMax', diceMax);
        for (let i=curPos+1; i < diceMax; i++) {
            if (visited[i] == undefined || visited[i] > curLevel+1) {
                visited[i] = curLevel+1;
                //console.log('push', [i, curLevel+1]);
                q.push([i, curLevel+1]);
            }
        }
        
    }
    return -1;
};