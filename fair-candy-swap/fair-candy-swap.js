/**
 * @param {number[]} aliceSizes
 * @param {number[]} bobSizes
 * @return {number[]}
 */
var fairCandySwap = function(aliceSizes, bobSizes) {
    let aliceSum = aliceSizes.reduce((acc, value) => acc+value, 0);
    let bobMap = {};
    let bobSum = bobSizes.reduce((acc, value) => {
        bobMap[value] = true;
        return acc+value;
    }, 0);
    for (let i=0; i<aliceSizes.length; i++) {
        let target = (bobSum-aliceSum+aliceSizes[i]*2)/2;
        if (!!bobMap[target]) {
            return [aliceSizes[i], target];
        }
    }
};