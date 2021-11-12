/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isMonotonic = function(nums) {
    function isMonotonicIncreasing() {
        for (let i=0; i<nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                return false;
            }
        }
        return true;
    }
    function isMonotonicDecreasing() {
        for (let i=0; i<nums.length-1; i++) {
            if (nums[i] < nums[i+1]) {
                return false;
            }
        }
        return true;
    }
    return isMonotonicIncreasing() || isMonotonicDecreasing();
};