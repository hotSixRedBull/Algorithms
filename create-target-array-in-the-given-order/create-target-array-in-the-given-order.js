/**
 * @param {number[]} nums
 * @param {number[]} index
 * @return {number[]}
 */
var createTargetArray = function(nums, index) {
    let ansArr = [];
    for (let i=0; i<nums.length; i++) {
        if (index[i] == ansArr.length) {
            ansArr.push(nums[i]);
        }
        else {
            ansArr.splice(index[i], 0, nums[i]);
        }
    }
    return ansArr;
};