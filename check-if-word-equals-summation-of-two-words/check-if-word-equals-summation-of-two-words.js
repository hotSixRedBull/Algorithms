/**
 * @param {string} firstWord
 * @param {string} secondWord
 * @param {string} targetWord
 * @return {boolean}
 */
var isSumEqual = function(firstWord, secondWord, targetWord) {
    let base = 'a'.charCodeAt(0);
    function getValue(word) {
        let ans = 0;
        for (let i=0;i<word.length;i++) {
            ans += word.charCodeAt(i)-base;
            ans *= 10;
        }
        return ans;
    }
    return getValue(firstWord) + getValue(secondWord) == getValue(targetWord);
};