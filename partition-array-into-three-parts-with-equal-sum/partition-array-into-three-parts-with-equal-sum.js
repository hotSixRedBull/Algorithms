/**
 * @param {number[]} arr
 * @return {boolean}
 */
var canThreePartsEqualSum = function(arr) {
    let sum = [0,arr[0],arr[1]];
    let allSum = arr.reduce((acc,item) => acc+=item,0);
    for (let p1=1;p1<arr.length-1;p1++) {
        sum[0] += arr[p1-1];
        sum[1] = 0;
        sum[2] = allSum - sum[0] -sum[1];
        for (let p2=p1+1;p2<arr.length;p2++) {
            sum[1] += arr[p2-1];
            sum[2] -= arr[p2-1];
            //console.log(`p1: ${p1}, p2: ${p2}, sum: ${sum}`);
            if (sum[0] == sum[1] && sum[1] == sum[2]) {
                return true;
            }
        }
    }
    return false;
};