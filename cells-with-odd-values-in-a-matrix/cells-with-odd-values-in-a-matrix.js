/**
 * @param {number} m
 * @param {number} n
 * @param {number[][]} indices
 * @return {number}
 */
var oddCells = function(m, n, indices) {
    let rowCnt = {};
    let colCnt = {};
    for (let i=0; i<indices.length; i++) {
        if (rowCnt[indices[i][0]] == undefined) {
            rowCnt[indices[i][0]] = 1;
        }
        else {
            rowCnt[indices[i][0]]++;
        }
        if (colCnt[indices[i][1]] == undefined) {
            colCnt[indices[i][1]] = 1;
        }
        else {
            colCnt[indices[i][1]]++;
        }
    }
    //console.log(rowCnt, colCnt)
    let cnt = 0;
    for (let i=0; i<m; i++) {
        for (let j=0; j<n; j++) {
            let row = rowCnt[i] != undefined ? rowCnt[i]:0;
            let col = colCnt[j] != undefined ? colCnt[j]:0;
            if ((row+col) % 2 == 1) {
                cnt++;
            }
        }
    }
    return cnt;
};