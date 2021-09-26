/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var rotateString = function(s, goal) {
    let start = goal[0];
    let stk = [];
    for (let i=0; i<s.length; i++) {
        if (s[i] == start) {
            stk.push(i);
        }
    }
    
    while (stk.length > 0) {
        let cur = stk.pop();
        if (s.substring(cur, s.length)+s.substring(0, cur) == goal) {
            return true;
        }
    }
    return false;
};