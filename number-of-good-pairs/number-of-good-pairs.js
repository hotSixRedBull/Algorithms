/**
 * @param {number[]} nums
 * @return {number}
 */
var numIdenticalPairs = function(nums) {
    let map = {};
    for (let i=0; i<nums.length; i++) {
        if (!map[nums[i]]) {
            map[nums[i]] = [i];
        }
        else {
            map[nums[i]].push(i);
        }
    }
    let res = 0;
    for (let elem in map) {
        for (let i=1; i<map[elem].length; i++) {
            res += i;
        }
    }
    return res;
};