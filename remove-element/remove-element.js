/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function(nums, val) {
    let cnt = 0;
    for (let i=0; i<nums.length; i++) {
        if (nums[i] == val) {
            cnt++;
        }
    }
    let left = 0;
    let right = nums.length-1;
    while (left < right) {
        if (nums[left] != val) {
            left++;
        }
        else if (nums[right] == val) {
            right--;
        }
        else if (nums[left] == val && nums[right] != val) {
            [nums[left], nums[right]] = [nums[right], nums[left]];
            left++;
            right--;
        }
    }
    return nums.length-cnt;
};