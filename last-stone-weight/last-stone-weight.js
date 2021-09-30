/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function(stones) {
    stones.sort((a, b) => a - b);
    let index = stones.length-1;
    while (index > 0) {
        let y = stones[index];
        let x = stones[index-1];
        if (x == y) {
            index -= 2;
        }
        else {
            index--;
            stones[index] = y-x;
            stones.sort((a, b) => a - b);
        }
        //console.log(stones)
    }
    return index == 0 ? stones[0] : 0;
};