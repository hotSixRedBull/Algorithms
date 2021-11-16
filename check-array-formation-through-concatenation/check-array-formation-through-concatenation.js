/**
 * @param {number[]} arr
 * @param {number[][]} pieces
 * @return {boolean}
 */
var canFormArray = function(arr, pieces) {
    let q = [];
    let visit = {};
    let ans = 0;
    let arrIndex = 0;
    while (true) {
        for (let i=0; i<pieces.length; i++) {
            if (visit[i] != undefined) {
                continue;
            }
            if (arr[arrIndex] == pieces[i][0]) {
                let isSame = true;
                for (let j=0; j<pieces[i].length; j++) {
                    if (arr[arrIndex+j] != pieces[i][j]) {
                        isSame = false;
                        break;
                    }
                }
                if (isSame) {
                    visit[i] = true;
                    arrIndex += pieces[i].length;
                    if (arrIndex == arr.length) {
                        return true;
                    }
                    q.push(pieces[i]);
                }
            }
        }
        if (q.length == 0) {
            return false;
        }
        q.pop();
    }
};