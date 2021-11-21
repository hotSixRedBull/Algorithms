/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNonDuplicate = function(nums) {
    let left = 0;
    let right = nums.length-1;
    while (left < right) {
        let mid = Math.floor(left - ((left - right)/2));
        if (
            (mid > 0 && nums[mid] != nums[mid-1] 
             && mid < nums.length-1 && nums[mid] != nums[mid+1])
           || (mid == 0 && nums[mid] != nums[mid+1])
           || (mid == nums.length-1 && nums[mid-1] != nums[mid])
        ) {
            return nums[mid];
        } 
        if (mid > 0 && nums[mid] == nums[mid-1]) {
            if (mid % 2 == 1) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        if (mid < nums.length-1 && nums[mid] == nums[mid+1]) {
            if (mid % 2 == 0) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
    }
    return nums[left];
};