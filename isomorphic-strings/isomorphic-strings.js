/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isIsomorphic = function(s, t) {
    let used = {};
    let changed = Array(s.length).fill(false);
    let sArr = s.split('');
    let tArr = t.split('');
    //console.log(changed);
    for (let i=0;i<sArr.length;i++) {
        let target = sArr[i];
        if (sArr[i] != tArr[i]) {
            if (changed[i] == true 
                || used[tArr[i]] != undefined) {
                return false;
            }
            else {
                used[tArr[i]] = 1;
                for (let j=0; j<sArr.length; j++) {
                    if (sArr[j] == target && changed[j] == false) {
                        //console.log(sArr[j], tArr[i]);
                        sArr[j] = tArr[i];
                        changed[j] = true;
                    }
                }
                //console.log(sArr, tArr);
            }
        }
        else if(changed[i] == false) {
            if (used[tArr[i]] != undefined) {
                return false;
            }
            used[tArr[i]] = 1;
            for (let j=0; j<sArr.length; j++) {
                if (sArr[j] == target && changed[j] == false) {
                    changed[j] = true;
                }
            }
        }
    }
    //console.log(sArr, tArr);
    return sArr.join('') == tArr.join('');
};