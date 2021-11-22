/**
 * @param {string} s
 * @return {string}
 */
var longestNiceSubstring = function(s) {
    let max = 0;
    let ans = "";
    function isNice(string) {
        let set = new Set(string.split(''));
        let alphaMap = {};
        let aToNumber = 'a'.charCodeAt(0);
        let AToNumber = 'A'.charCodeAt(0);
        for (let i=0; i<26; i++) {
            let hasLower = set.has(String.fromCharCode(aToNumber+i));
            let hasUpper = set.has(String.fromCharCode(AToNumber+i));
            if (hasLower ^ hasUpper == 1) {
                //console.log(string, "isn't nice.");
                return false;
            }
        }
        //console.log(string, "is nice.");
        return true;
    }
    for (let i=0; i<s.length-1; i++) {
        for (let j=i+1; j<=s.length; j++) {
            let target = s.substring(i, j);
            if (isNice(target) && j-i+1 > max) {
                max = j-i+1;
                ans = target;
            }
        }
    }
    return ans;
};