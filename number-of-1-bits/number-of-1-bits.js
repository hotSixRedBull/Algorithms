/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function(n) {
    let cnt = 0;
    while (n != 0) {
        n = n & (n-1);
        cnt++;
    }
    return cnt;
};