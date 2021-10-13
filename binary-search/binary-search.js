/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left=0;
    let right=nums.length-1;
    while (left < right) {
        let cur = Math.floor(left - (left-right)/2);
        if (target < nums[cur]) {
            right = cur-1;
        }
        else if (target > nums[cur]) {
            left = cur+1;
        }
        else {
            return cur;
        }
    }
    if (nums[left] == target) {
        return left;
    }
    return -1;
};