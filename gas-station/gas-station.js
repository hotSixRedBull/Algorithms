/**
 * @param {number[]} gas
 * @param {number[]} cost
 * @return {number}
 */
var canCompleteCircuit = function(gas, cost) {
    let calcArr = [];
    for (let i=0; i<gas.length; i++) {
        calcArr.push(gas[i]-cost[i]);
    }
    //console.log('calcArr', calcArr)
    let ans = -1;
    for (let i=0; i<calcArr.length;i++) {
        let cur = calcArr[i];
        //console.log('cur',cur)
        if (cur < 0) {
            continue;
        }
        let curIndex = i+1;
        while (cur >= 0) {
            //console.log('while cur',cur)
            if (curIndex == calcArr.length) {
                curIndex = 0;
            }
            if (curIndex == i) {
                break;
            }
            cur += calcArr[curIndex++];
        }
        if (cur >= 0) {
            ans = i;
            break;
        }
    }
    
    return ans;
};