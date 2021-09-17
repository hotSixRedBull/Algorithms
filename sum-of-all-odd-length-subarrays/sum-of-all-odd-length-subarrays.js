/**
 * @param {number[]} arr
 * @return {number}
 */
var sumOddLengthSubarrays = function(arr) {
    let res = 0;
    for (let len=1; len<arr.length+1; len+=2) {
        let cur = 0;
        for (let i=0; i<len; i++) {
            cur += arr[i];
        }
        res += cur;
        for (let i=len; i<arr.length; i++) {
            cur -= arr[i-len];
            cur += arr[i];
            res += cur;
        }
    }
    return res;
};