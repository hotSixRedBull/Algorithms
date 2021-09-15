/**
 * @param {number[]} nums
 * @return {number[]}
 */
var frequencySort = function(nums) {
    let map = {};
    for (let i=0; i<nums.length; i++) {
        if (!map[nums[i]]) {
            map[nums[i]] = 1;
        }
        else {
            map[nums[i]]++;
        }
    }
    
    map = Object.entries(map).sort((a, b) => {
        if (a[1] == b[1]) {
            return parseInt(b[0],10) - parseInt(a[0],10);
        }
        return a[1] - b[1];
    });
    let res = [];
    for (let elem of map) {
        res = [...res, ...Array(elem[1]).fill(elem[0])];
    }
    return res;
};