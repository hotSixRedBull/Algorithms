/**
 * @param {string} word
 * @param {string} abbr
 * @return {boolean}
 */
var validWordAbbreviation = function(word, abbr) {
    let abbrIndex = 0;
    let wordIndex = 0;
    let numSet = new Set('0123456789');
    let ret = true;
    for (; abbrIndex<abbr.length; abbrIndex++, wordIndex++) {
        if (abbr[abbrIndex] == '0') {
            ret = false;
            break;
        }
        else if (numSet.has(abbr[abbrIndex])) {
            let start = abbrIndex;
            while (numSet.has(abbr[abbrIndex])) {
                abbrIndex++;
            }
            let cnt = parseInt(abbr.slice(start,abbrIndex), 10);
            wordIndex += cnt;
        }
        //console.log(`word[wordIndex]: ${word[wordIndex]}, abbr[abbrIndex]: ${abbr[abbrIndex]}`);
        if (wordIndex > word.length || abbrIndex > abbr.length || word[wordIndex] != abbr[abbrIndex]) {
            ret = false;
            break;
        }
    }
    if (wordIndex < word.length) {
        ret = false;
    }
    return ret;
};