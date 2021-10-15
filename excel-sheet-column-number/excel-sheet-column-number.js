/**
 * @param {string} columnTitle
 * @return {number}
 */
var titleToNumber = function(columnTitle) {
    let ans = 0;
    for (let i=0;i<columnTitle.length;i++) {
        ans *= 26;
        ans += columnTitle.charCodeAt(i)-'A'.charCodeAt(0)+1;
    }
    return ans;
};