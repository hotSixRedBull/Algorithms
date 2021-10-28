/**
 * @param {string} s
 * @return {string}
 */
var reverseVowels = function(s) {
    let sArr = s.split('');
    let vowelStk = [];
    let indexArr = [];
    let vowels = new Set(['a','e','i','o','u','A','E','I','O','U']);
    for (let i=0; i<s.length; i++) {
        if (vowels.has(s[i])) {
            vowelStk.push(s[i]);
            indexArr.push(i);
        }
    }
    for (let i=0; i<indexArr.length; i++) {
        sArr[indexArr[i]] = vowelStk.pop();
    }
    return sArr.join('');
};