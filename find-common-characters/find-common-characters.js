/**
 * @param {string[]} words
 * @return {string[]}
 */
var commonChars = function(words) {
    let first = words[0].split('');
    let res = [];
    for (let char of first) {
        if (words.every(word => word.includes(char))) {
            res.push(char);
            words = words.map(word => word.replace(char, ''));
        }
    }
    return res;
};