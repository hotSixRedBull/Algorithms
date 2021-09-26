/**
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    let cnt = 0;
    for (let i=5; i<=n; i+=5) {
        let cur = i;
        let tmpCnt = 0;
        while (cur > 0 && cur%5 == 0) {
            tmpCnt++;
            cur = Math.floor(cur/5);
        }
        cnt += tmpCnt;
    }
    return cnt;
};