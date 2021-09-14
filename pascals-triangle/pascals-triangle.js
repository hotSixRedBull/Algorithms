/**
 * @param {number} numRows
 * @return {number[][]}
 */
var generate = function(numRows) {
    let result = [];
    let tmp = [];
    for (let i=0;i<numRows;i++) {
        for(let j=1;j<i;j++) {
            tmp[j] = result[i-1][j-1] + result[i-1][j];
        }
        tmp.push(1);
        result.push(tmp.slice());
        //console.log(result);
    }
    return result;
};