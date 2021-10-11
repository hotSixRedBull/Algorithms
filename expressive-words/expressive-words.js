/**
 * @param {string} s
 * @param {string[]} words
 * @return {number}
 */
var expressiveWords = function(s, words) {
    
    function makeList(word, isWord) {
        let cur = word[0];
        let cnt = 0;
        let list = [];
        for (let i=0; i<word.length; i++) {
            if (word[i] == cur) {
                cnt++;
            }
            else {
                if (cnt < 3 || isWord) {
                    //value, min, max
                    list.push({
                        'val': cur, 
                        'min': cnt, 
                        'max': cnt
                    });
                }
                else {
                    list.push({
                        'val': cur, 
                        'min': 1, 
                        'max': cnt
                    });
                }
                cur = word[i];
                cnt = 1;
            }
        }
        if (cnt < 3 || isWord) {
            //value, min, max
            list.push({
                'val': cur, 
                'min': cnt, 
                'max': cnt
            });
        }
        else {
            list.push({
                'val': cur, 
                'min': 1, 
                'max': cnt
            });
        }
        return list;
    }
    let sList = makeList(s);
    //console.log(sList);
    let ansCnt = 0;
    for (let i=0; i<words.length; i++) {
        let wordList = makeList(words[i], true);
        //console.log(wordList);
        if (sList.length != wordList.length) {
            continue;
        }
        else {
            for (let j=0; j<sList.length; j++) {
                if ((sList[j].val != wordList[j].val)
                   ||(sList[j].max < wordList[j].min)
                   ||(sList[j].min > wordList[j].max)) {
                    break;
                }
                else if(j == sList.length-1) {
                    ansCnt++;
                }
            }
        }
    }
    return ansCnt;
};