/**
 * @param {string} s
 * @return {number}
 */
var maxDepth = function(s) {
    let ans = 0;
    let tmp = 0;
    for (let i=0; i<s.length; i++) {
        if (s[i] == '(') {
            tmp += 1;
            ans = Math.max(ans, tmp);
        }
        else if(s[i] == ')') {
            tmp -= 1;
        }
    }
    return ans;
};