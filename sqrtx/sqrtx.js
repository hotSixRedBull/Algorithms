/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
    let i = 0;
    for (i = 0; i <= x; i++) {
        if (i*i == x) {
            return i;
        }
        if (i*i > x) {
            return i-1;
        }
    }
    return i;
};