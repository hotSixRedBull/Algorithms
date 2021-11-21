/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var topKFrequent = function(nums, k) {
    let map = {};
    for (let i=0; i<nums.length; i++) {
        if (map[nums[i]] == undefined) {
            map[nums[i]] = 0;
        }
        map[nums[i]]++;
    }
    let entries = Object.entries(map);
    entries.sort((a, b) => b[1]-a[1]);
    console.log(entries);
    let ans = [];
    for (let i=0; i<k; i++) {
        ans.push(parseInt(entries[i][0], 10));
    }
    return ans;
};