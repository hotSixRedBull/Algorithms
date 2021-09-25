/**
 * @param {number} n
 * @return {boolean}
 */
var divisorGame = function(n) {
    function getDivisors(num) {
        let res = [];
        for (let d=1; d<=Math.floor(Math.sqrt(num)); d++) {
            if (num%d == 0) {
                res.push(d);
            }
        }
        return res;
    }
    let dp = [false, false, true, false];
    function canWin(num) {
        if (dp.length > num) {
            return dp[num];
        }
        else {
            let divisors = getDivisors(num);
            let res = false;
            for (let divisor of divisors) {
                res |= canWin(divisor);
            }
            return res;
        }
    }
    return canWin(n);
};