/**
 * @param {string[]} wordsDict
 */
var WordDistance = function(wordsDict) {
    this.cache = {};
    this.indexMap = {};
    this.toInteger = function(string) {
        // let acc = 0;
        // for (let i=0; i<string.length; i++) {
        //     acc += string.charCodeAt(i) - 'a'.charCodeAt(0);
        //     acc = acc << 5;
        // }
        // return acc;
        return string;
    }
    for (let i=0; i<wordsDict.length; i++) {
        let key = this.toInteger(wordsDict[i]);
        //console.log('key', key);
        if (this.indexMap[key] == undefined) {
            this.indexMap[key] = [];
        }
        this.indexMap[key].push(i);
    }
    //console.log(this.indexMap);
};

/** 
 * @param {string} word1 
 * @param {string} word2
 * @return {number}
 */
WordDistance.prototype.shortest = function(word1, word2) {
    if (this.cache[`${word1},${word2}`] != undefined) {
        return this.cache[`${word1},${word2}`];
    }
    let word1Integer = this.toInteger(word1);
    let word2Integer = this.toInteger(word2);
    let word1IndexArr = this.indexMap[word1Integer];
    let word2IndexArr = this.indexMap[word2Integer];
    //console.log('word1Integer', word1Integer, 'word2Integer', word2Integer)
    let min = Number.MAX_SAFE_INTEGER;
    for (let i=0; i<word1IndexArr.length; i++) {
        for (let j=0; j<word2IndexArr.length; j++) {
            //console.log('alan, min,', min);
            min = Math.min(min, Math.abs(word1IndexArr[i]-word2IndexArr[j]));
        }
    }
    this.cache[`${word1},${word2}`] = min;
    return min;
};

/** 
 * Your WordDistance object will be instantiated and called as such:
 * var obj = new WordDistance(wordsDict)
 * var param_1 = obj.shortest(word1,word2)
 */