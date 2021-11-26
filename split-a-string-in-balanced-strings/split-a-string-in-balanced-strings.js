/**
 * @param {string} s
 * @return {number}
 */
var balancedStringSplit = function(s) {
    let cntMap = {
        'R':0,
        'L':0,
    };
    cntMap[s[0]]++;
    let ans = 0;
    for (let i=1; i<s.length; i++) {
      cntMap[s[i]]++;
      if (cntMap['R'] == cntMap['L']) {
          ans++;
      }
    }
    return ans;
};