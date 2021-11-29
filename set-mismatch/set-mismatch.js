/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findErrorNums = function(nums) {
    let obj = {};
    let ans = [];
    for (let i=0; i<nums.length; i++) {
        if (obj[nums[i]] == undefined) {
            obj[nums[i]] = 1;
        }
        else {
            ans.push(nums[i]);
            obj[nums[i]]++;
        }
    }
    for (let i=0; i<nums.length; i++) {
        if (obj[i+1] == undefined) {
            ans.push(i+1);
            break;
        }
    }
    return ans;
};