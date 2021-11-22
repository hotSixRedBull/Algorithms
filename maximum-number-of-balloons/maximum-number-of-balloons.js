/**
 * @param {string} text
 * @return {number}
 */
var maxNumberOfBalloons = function(text) {
    let obj = {};
    for (let i=0; i<text.length; i++) {
        if (obj[text[i]] == undefined) {
            obj[text[i]] = 0;
        }
        obj[text[i]]++;
    }
    //console.log(obj)
    let searchKeyword = 'ban';
    let min = Number.MAX_SAFE_INTEGER;
    for (let i=0; i<searchKeyword.length; i++) {
        if (obj[searchKeyword[i]] == undefined) {
            min = 0;
        }
        else {
            min = Math.min(min, obj[searchKeyword[i]]);
        }
    }
    searchKeyword = 'lo';
    for (let i=0; i<searchKeyword.length; i++) {
        if (obj[searchKeyword[i]] == undefined) {
            min = 0;
        }
        else {
            min = Math.min(min, Math.floor(obj[searchKeyword[i]]/2));
        }
    }
    return min;
};