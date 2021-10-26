/**
 * @param {number} n
 * @return {number[]}
 */
var countBits = function(n) {
    let ans = [];
    function countOneBit(num) {
        let copy = num;
        let ans = 0;
        while (copy > 0) {
            if (copy % 2 == 1) {
                ans++;
                copy -= 1;
            }
            copy /= 2;
        }
        return ans;
    }
    for (let i=0; i<=n; i++) {
        ans.push(countOneBit(i));
    }
    return ans;
};
    
/*
5 = 2*2 + 1
2 = 2*1 + 0
1 = 2*0 + 1
*/