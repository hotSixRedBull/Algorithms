/**
 * @param {number[][]} matrix
 * @return {number[]}
 */
var spiralOrder = function(matrix) {
    let ans = [];
    let leftBound = 0;
    let rightBound = matrix[0].length-1;
    let topBound = 0;
    let bottomBound = matrix.length-1;
    let limit = (rightBound+1)*(bottomBound+1);
    // console.log('rightBound',rightBound,'bottomBound',bottomBound);
    while (leftBound <= rightBound && topBound <= bottomBound) {
        for (let c = leftBound; c <= rightBound && ans.length < limit; c++) {
            // console.log(matrix[topBound][c]);
            ans.push(matrix[topBound][c]);
        }
        for (let r = ++topBound; r <= bottomBound && ans.length < limit; r++) {
            // console.log(matrix[r][rightBound]);
            ans.push(matrix[r][rightBound]);
        }
        for (let c = --rightBound; c >= leftBound && ans.length < limit; c--) {
            // console.log(matrix[bottomBound][c]);
            ans.push(matrix[bottomBound][c]);
        }
        for (let r = --bottomBound; r >= topBound && ans.length < limit; r--) {
            // console.log(matrix[r][leftBound]);
            ans.push(matrix[r][leftBound]);
        }
        leftBound++;
    }
    return ans;
}