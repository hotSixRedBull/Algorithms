/**
 * @param {string} s
 * @return {boolean}
 */
var canPermutePalindrome = function(s) {
    let freq = {};
    for (let i=0; i<s.length; i++) {
        if (freq[s[i]] == undefined) {
            freq[s[i]] = 0;
        }
        freq[s[i]]++;
    }
    
    let sum = s.length;
    for (let k of Object.keys(freq)) {
        sum -= freq[k];
        freq[k] = freq[k]%2;
        sum += freq[k];
    }
    
    if (sum <= 1) {
        return true;
    }
    else {
        return false;
    }
};