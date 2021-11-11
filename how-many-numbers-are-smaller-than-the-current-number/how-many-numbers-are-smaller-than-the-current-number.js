/**
 * @param {number[]} nums
 * @return {number[]}
 */
var smallerNumbersThanCurrent = function(nums) {
    let sortedNums = nums.slice();
    sortedNums.sort((a, b) => a-b);
    let cache = {};
    function findTheLeastIndex(val) {
        if (cache[val] != undefined) {
            return cache[val];
        }
        let left = 0;
        let right = sortedNums.length-1;
        while (left != right) {
            let mid = Math.floor(left + ((right - left) / 2));
            if (sortedNums[mid] < val) {
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        cache[val] = left;
        return cache[val];
    }
    for (let i=0; i<nums.length; i++) {
        nums[i] = findTheLeastIndex(nums[i]);
    }
    return nums;
};