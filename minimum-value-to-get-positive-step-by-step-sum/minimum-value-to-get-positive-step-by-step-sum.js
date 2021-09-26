/**
 * @param {number[]} nums
 * @return {number}
 */
var minStartValue = function(nums) {
    let sum = 0;
    let min = Number.MAX_SAFE_INTEGER;
    nums.forEach(item => {
        sum += item;
        min = Math.min(sum, min);
    });
    return Math.max(1 - min, 1);
};