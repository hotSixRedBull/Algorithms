/**
 * @param {string} ransomNote
 * @param {string} magazine
 * @return {boolean}
 */
var canConstruct = function(ransomNote, magazine) {
    let magazineMap = {};
    for (let i=0; i<magazine.length; i++) {
        if (magazineMap[magazine[i]] == undefined) {
            magazineMap[magazine[i]] = 1;
        }
        else {
            magazineMap[magazine[i]]++;
        }
    }
    
    for (let i=0; i<ransomNote.length; i++) {
        if (magazineMap[ransomNote[i]] == 0
           || magazineMap[ransomNote[i]] == undefined) {
            return false;
        }
        else {
            magazineMap[ransomNote[i]]--;
        }
    }
    
    return true;
};