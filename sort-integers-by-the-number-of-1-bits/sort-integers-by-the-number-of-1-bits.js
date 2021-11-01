/**
 * @param {number[]} arr
 * @return {number[]}
 */
var sortByBits = function(arr) {
    arr = arr.sort((a, b) => {
        //console.log(`a: ${a}, b: ${b}`)
        let aCnt = 0;
        let bCnt = 0;
        let copyA = a;
        let copyB = b;
        while (copyA > 0) {
            copyA &= copyA-1;
            aCnt++;
        }
        while (copyB > 0) {
            copyB &= copyB-1;
            bCnt++;
        }
        if (aCnt == bCnt) {
            if (a == b) {
                return 0;
            }
            return a - b;
        }
        else {
            return aCnt - bCnt;
        }
    });
    return arr;
};