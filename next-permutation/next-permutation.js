/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var nextPermutation = function(nums) {
    let pos = -1;
    for (let i=nums.length-1; i>0; i--) {
        if (nums[i-1] < nums[i]) {
            pos = i-1;
            break;
        }
    }
    // console.log(pos);
    // find bigger one
    if (pos > -1) {
        let largerPos = pos+1;
        for (let i=pos+1; i<nums.length; i++) {
            if (nums[pos] < nums[i]) {
                largerPos = i;
            }
        }
        [nums[pos], nums[largerPos]] = [nums[largerPos], nums[pos]];
    }
    // console.log(nums);
    // reverse
    for (let i=0; 2*i+pos+1<nums.length; i++) {
        let tmp = nums[pos+1+i];
        nums[pos+1+i] = nums[nums.length-1-i];
        nums[nums.length-1-i] = tmp;
    }
    // console.log(nums);
    return nums;
};