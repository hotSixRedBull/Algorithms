/**
 * @param {string} s
 * @return {string}
 */
var minRemoveToMakeValid = function(s) {
    let balance = 0;
    let stk = [];
    let str = s.split('');
    for (let i=0; i<str.length; i++) {
        if (str[i] == '(') {
            stk.push(i);
        }
        if (str[i] == ')') {
            if (stk.length == 0) {
                str[i] = '';
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
        str[cur] = ''
    }
    return str.join('');
};