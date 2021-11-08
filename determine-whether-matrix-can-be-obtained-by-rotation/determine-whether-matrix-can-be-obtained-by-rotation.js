/**
 * @param {number[][]} mat
 * @param {number[][]} target
 * @return {boolean}
 */
var findRotation = function(mat, target) {
    let matCopy = [];
    for (let i=0; i<mat.length; i++) {
        matCopy.push([...mat[i]]);
    }
    
    function rotate() {
        let tmpArr = [];    
        for (let i=0; i<matCopy.length; i++) {
            tmpArr.push([...matCopy[i]]);
        }
        for (let r=0; r<matCopy.length; r++) {
            for (let c=0; c<matCopy.length; c++) {
                matCopy[c][r] = tmpArr[matCopy.length-r-1][c];
            }
        }
    }
    
    function isEqual(arr, target) {
        for (let r=0; r<matCopy.length; r++) {
            for (let c=0; c<matCopy.length; c++) {
                if (arr[r][c] != target[r][c]) {
                    return false;   
                }
            }
        }
        return true;
    }
    
    let rotateCnt = 0;
    while (rotateCnt < 4) {
        if (isEqual(matCopy, target)) {
            return true;
        }
        else {
            rotate();
            rotateCnt++;
        }
    }
    return false;
};