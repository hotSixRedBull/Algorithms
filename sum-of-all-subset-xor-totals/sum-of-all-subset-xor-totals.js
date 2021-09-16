/**
 * @param {number[]} nums
 * @return {number}
 */
var subsetXORSum = function(nums) {
    let possibility = 2**nums.length;
    let res = 0;
    for (let i=0; i<possibility; i++) {
        //console.log(`!!!\ni is ${i}`);
        let pos = 0;
        let cur = 0;
        for (let tmp = i; tmp > 0; tmp = tmp >> 1) {
            //console.log(`tmp is ${tmp}`);
            if (tmp%2 == 1) {
                //console.log(`in ${i}, ${nums[pos]} exists.`)
                cur ^= nums[pos];
            }
            pos++;
        }
        res += cur;
    }
    return res;
};