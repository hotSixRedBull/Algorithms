/**
 * @param {number[]} g
 * @param {number[]} s
 * @return {number}
 */
var findContentChildren = function(g, s) {
    g.sort((a, b) => a-b);
    s.sort((a, b) => a-b);
    let ans = 0;
    let cookiePointer = 0;
    for (let i=0; i<g.length; i++) {
        while (cookiePointer < s.length && s[cookiePointer] < g[i]) {
            cookiePointer++;
        }
        if (cookiePointer < s.length && s[cookiePointer] >= g[i]) {
            ans++;
            cookiePointer++;
        }
    }
    return ans;
};