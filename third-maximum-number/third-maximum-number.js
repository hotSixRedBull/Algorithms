/**
 * @param {number[]} nums
 * @return {number}
 */
var thirdMax = function(nums) {
    let arr = Array.from(new Set(nums));
    arr.sort((a,b) => b-a);
    if (arr.length >= 3) {
        return arr[2];
    }
    else {
        return arr[0];
    }
};