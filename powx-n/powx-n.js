/**
 * @param {number} x
 * @param {number} n
 * @return {number}
 */
var myPow = function(x, n) {
    let ans = 1;
    let multiply = x;
    if (n < 0) {
        multiply = 1/x;
        n = -n;
    }
    
    let skip = 0;
    for (let i=1; i<n; i*=2) {
        skip++;
    }
    //console.log('skip', skip);
    if (skip > 0) {
        let acc = multiply;
        for (let i=1; i<skip; i++) {
            acc = acc**2;
        }
        //console.log('acc', acc);
        ans *= acc;
    }
    for (let i=2**(skip-1); i<n; i++) {
        ans *= multiply;
    }
    //console.log('ans', ans);
    return ans;
};