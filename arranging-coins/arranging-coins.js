/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function(n) {
    function getCoins(stair) {
        return stair*(stair+1)/2;
    }
    let left = 1;
    let right = n;
    let cur = 1;
    let calc = 1;
    while (left < right) {
        cur = Math.floor(right - (right-left)/2);
        calc = getCoins(cur);
        //console.log(`cur: ${cur}, calc: ${calc}`)
        if (calc < n) {
            left = cur+1;
        }
        else if (calc > n) {
            right = cur-1;
        }
        else {
            left = cur+1;
            right = cur+1;
        }
    }
    //console.log(`left: ${left}, right: ${right}`)
    if (getCoins(left) <= n) {
        return left;
    }
    else {
        return left-1;
    }
};