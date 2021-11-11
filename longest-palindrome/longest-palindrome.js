/**
 * @param {string} s
 * @return {number}
 */
var longestPalindrome = function(s) {
    let cache = {};
    for (let i=0; i<s.length; i++) {
        if (cache[s[i]] == undefined) {
            cache[s[i]] = 0;
        }
        cache[s[i]]++;
    }
    
    let max = 0;
    for (let key in cache) {
        if (cache[key] >= 2) {
            max += Math.floor(cache[key]/2)*2;
            cache[key] = cache[key] % 2;
        }
    }
    
    for (let key in cache) {
        if (cache[key] == 1) {
            max += 1;
            break;
        }
    }
    
    return max;
};