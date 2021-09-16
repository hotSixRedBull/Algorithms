/**
 * @param {number[][]} logs
 * @return {number}
 */
var maximumPopulation = function(logs) {
    let arr = Array(100).fill(0);
    let res = 1950;
    let maxP = 0;
    for (let [birth, death] of logs) {
        for (let i=birth; i<death; i++) {
            arr[i-1950]++;
            if(maxP < arr[i-1950] || (maxP == arr[i-1950] && i < res)) {
                maxP = arr[i-1950];
                res = i;
            }
        }
    }
    return res;
};