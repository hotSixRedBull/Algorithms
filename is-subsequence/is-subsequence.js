/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isSubsequence = function(s, t) {
    let pos = 0;
    for (let char of s) {
        pos = pos == 0 ? 0 : pos+1;
        //console.log(pos)
        pos = t.indexOf(char, pos);
        if (pos == -1) {
            return false;
        }
    }
    return true;
};