/**
 * @param {number} n
 * @return {boolean}
 */
var isPowerOfTwo = function(n) {
    let target = n;
    target = target & (target-1);
    if (target == 0) {
        return n > 0 && true;
    }
    return false;
};