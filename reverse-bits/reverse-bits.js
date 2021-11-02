/**
 * @param {number} n - a positive integer
 * @return {number} - a positive integer
 */
var reverseBits = function(n) {
    if (n==0) {
        return 0;
    }
    
    let ans = 0;
    let nCopy = n;
    let cnt = 0;
    while (nCopy%2 == 0) {
        cnt++;
        nCopy /= 2;
    }
    //console.log('cnt', cnt);
    nCopy = n;
    while (nCopy > 0) {
        if (nCopy%2 == 1) {
            ans += 1;
            nCopy -= 1;
        }
        nCopy /= 2;
        ans*=2;
    }
    ans /= 2;
    let base = Math.pow(2, 31-cnt);
    while (base > ans) {
        ans *= 2;
    }
    return ans;
};