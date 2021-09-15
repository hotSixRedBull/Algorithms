/**
 * @param {number} columnNumber
 * @return {string}
 */
var convertToTitle = function(columnNumber) {
    let res = '';
    let cur = 0;
    let code = 'A'.charCodeAt(0)-1;
    while (columnNumber > 0) {
        cur = columnNumber%26;
        if (cur == 0) {
            cur = 26;
        }
        columnNumber = Math.floor((columnNumber-cur)/26);
        res = String.fromCharCode(code+cur) + res;
    }
    return res;
};