/**
 * @param {number} n
 * @return {number[]}
 */
var sumZero = function(n) {
    if (n==2) {
        return [-1,1];
    }
    let ans = [];
    for (let i=0; i<n-1; i++) {
        ans.push(i);
    }
    if (n > 0) {
        ans.push(-(n-2)*(n-1)/2);
    }
    console.log(ans);
    return ans;
};