/**
 * @param {number[]} cost
 * @return {number}
 */
var minCostClimbingStairs = function(cost) {
    let dp = cost.slice();
    for (let i=2; i<cost.length; i++) {
        dp[i] = Math.min(dp[i-1], dp[i-2]) + dp[i];
    }
    return Math.min(dp[dp.length-1], dp[dp.length-2]);
};