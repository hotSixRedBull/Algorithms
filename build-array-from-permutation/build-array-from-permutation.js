/**
 * @param {number[]} nums
 * @return {number[]}
 */
var buildArray = function(nums) {
    let arr = nums.slice();
    arr = arr.map((val, ind) => nums[nums[ind]]);
    return arr;
};