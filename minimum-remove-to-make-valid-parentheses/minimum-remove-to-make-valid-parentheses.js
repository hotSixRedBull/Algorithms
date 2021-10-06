/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function(s) {
    let balance = 0;
    let stk = [];
    for (let i=0; i<s.length; i++) {
        if (s[i] == '(') {
            stk.push(i);
        }
        if (s[i] == ')') {
            if (stk.length == 0) {
                s = s.substring(0, i) + s.substring(i+1, s.length);
                i--;
                continue;
            }
            else {
                stk.pop();
            }
        }
    }
    while (stk.length > 0) {
        let cur = stk.pop();
        s = s.substring(0, cur) + s.substring(cur+1, s.length);
    }
    return s;
};