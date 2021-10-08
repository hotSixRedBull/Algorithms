/**
 * @param {number[]} aliceSizes
 * @param {number[]} bobSizes
 * @return {number[]}
 */
var fairCandySwap = function(aliceSizes, bobSizes) {
    let aliceSum = aliceSizes.reduce((acc, value) => acc+value, 0);
    let bobSum = bobSizes.reduce((acc, value) => acc+value, 0);
    for (let i=0; i<aliceSizes.length; i++) {
        for (let j=0; j<bobSizes.length; j++) {
            if (aliceSum - bobSum == 2*(aliceSizes[i] - bobSizes[j]))  {
                return [aliceSizes[i], bobSizes[j]];
            }
        }
    }
};