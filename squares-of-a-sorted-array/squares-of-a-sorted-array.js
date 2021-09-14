/**
 * @param {number[]} nums
 * @return {number[]}
 */
var sortedSquares = function(nums) {
    let res = [];
    let stk = [];
    for (let i=0; i<nums.length; i++) {
        if (nums[i] < 0) {
            stk.push(nums[i]**2);
        }
        else {
            let tmp = nums[i]**2;
            while (tmp >= stk[stk.length-1]) {
                res.push(stk.pop());
            }
            res.push(tmp);
        }
    }
    while (stk.length > 0) {
        res.push(stk.pop());
    }
    return res;
};