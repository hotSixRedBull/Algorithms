/**
 * @param {string} s
 * @return {string}
 */
var originalDigits = function(s) {
    let obj = {};
    for (let i='a'.charCodeAt(0); i<='z'.charCodeAt(0); i++) {
        obj[String.fromCharCode(i)] = 0;
    }
    for (let i=0;i<s.length;i++) {
        obj[s[i]]++;
    }
    
    let arr = Array(10).fill(0);
    arr[0] = obj['z'];
    arr[2] = obj['w'];
    arr[4] = obj['u'];
    arr[6] = obj['x'];
    arr[8] = obj['g'];
    
    arr[3] = obj['h']-arr[8];
    arr[5] = obj['f']-arr[4];
    arr[7] = obj['s']-arr[6];
    
    arr[9] = obj['i']-arr[5]-arr[6]-arr[8];
    arr[1] = obj['n']-arr[7]-arr[9]*2;
    
    let res = '';
    arr.forEach((item, index) => {
        for (let i=0;i<item;i++) {
            res += index.toString();
        }
    });
    return res;
};