/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var backspaceCompare = function(s, t) {
    function makeString(str) {
        let ans = [];
        for (let i=0;i<str.length;i++) {
            if (str[i] == '#' && i > 0) {
                ans.pop();
            }
            else if(str[i] != '#') {
                ans.push(str[i]);
            }
        }
        //console.log(`${str}: ${ans}`);
        return ans.join('');
    }
    return makeString(s) == makeString(t);
};