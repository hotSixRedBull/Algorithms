/**
 * @param {number[][]} moves
 * @return {string}
 */
var tictactoe = function(moves) {
    let map = [...Array(3)].map(item => Array(3).fill(' '));
    let filled = 0;
    function checkWinner(target) {
        if (target.every(item => item == 'A')) {
            return 'A';
        }
        else if (target.every(item => item == 'B')) {
            return 'B';
        }
        return 'Not sure';
    }
    for (let i=0; i<moves.length; i++) {
        let target = i%2 == 0 ? 'A' : 'B';
        map[moves[i][0]][moves[i][1]] = target;
        filled++;
    }
    for (let i=0;i<3;i++) {
        //row
        let chk = checkWinner(map[i]);
        if (chk != 'Not sure') {
            return chk;
        }
        //column
        let target = [map[0][i], map[1][i], map[2][i]];
        chk = checkWinner(target);
        if (chk != 'Not sure') {
            return chk;
        }
    }
    let target = [map[0][0], map[1][1], map[2][2]];
    let chk = checkWinner(target);
    if (chk != 'Not sure') {
        return chk;
    }
    target = [map[0][2], map[1][1], map[2][0]];
    chk = checkWinner(target);
    if (chk != 'Not sure') {
        return chk;
    }
    if (filled == 9) {
        return "Draw";
    }
    else {
        return "Pending";
    }
};