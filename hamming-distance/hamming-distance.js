/**
 * @param {number} x
 * @param {number} y
 * @return {number}
 */
var hammingDistance = function(x, y) {
    let xbit = x&1;
    let ybit = y&1;
    let dist = 0;
    while (x != 0 || y != 0) {
        xbit = x&1;
        ybit = y&1;
        if (xbit != ybit) {
            dist++;
        }
        x = x >> 1;
        y = y >> 1;
    }
    return dist;
};