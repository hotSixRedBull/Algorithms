/**
 * @param {number[]} candies
 * @param {number} extraCandies
 * @return {boolean[]}
 */
var kidsWithCandies = function(candies, extraCandies) {
    let max = Number.MIN_SAFE_INTEGER;
    candies.forEach(item => {
        max = Math.max(item, max);
    });
    
    let res = Array(candies.length).fill(false);
    candies.forEach((item, index) => {
        if (item+extraCandies >= max) {
            res[index] = true;
        }
    });
    
    return res;
};