/**
 * @param {number[]} nums
 * @return {string[]}
 */
var summaryRanges = function(nums) {
    let start = null;
    let ans = [];
    if (nums.length == 0) {
        return [];
    }
    if (nums.length == 1) {
        return [nums[0].toString()];
    }
    for (let i=0; i<nums.length; i++) {
        if (start == null) {
            start = nums[i];
        }
        if (i < nums.length-1 && nums[i+1]-nums[i] > 1) {
            if (start == nums[i]) {
                ans.push(start.toString());
            }
            else {
                ans.push(`${start}->${nums[i]}`);
            }
            start = null;
        }
    }
    if (start != null) {
        if (start == nums[nums.length-1]) {
            ans.push(start.toString());
        }
        else {
            ans.push(`${start}->${nums[nums.length-1]}`);
        }
    }
    return ans;
};