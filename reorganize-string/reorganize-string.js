/**
 * @param {string} s
 * @return {string}
 */
var reorganizeString = function(s) {
    let obj = {};
    let max = [s[0], 1];
    for (let i=0; i<s.length; i++) {
        if (obj[s[i]] == undefined) {
            obj[s[i]] = 1;
        }
        else {
            obj[s[i]]++;
            if (max[1] < obj[s[i]]) {
                max = [s[i], obj[s[i]]];
            }
        }
    }
    let otherSum = 0;
    for (let key in obj) {
        if (key != max[0]) {
            otherSum += obj[key];
        }
    }
    //console.log('otherSum: ', otherSum);
    if (otherSum+1 < max[1]) {
        return "";
    }
    let ans = Array(s.length).fill('');
    for (let i=0; i<s.length; i+=2) {
        if (obj[max[0]] > 0) {
            ans[i] = max[0];
            obj[max[0]]--;
        }
        else {
            for (let key of Object.keys(obj)) {
                if (key == max[0]) {
                    continue;
                }
                else if(obj[key] > 0) {
                    ans[i] = key;
                    obj[key]--;
                    break;
                }
            }
        }
    }
    for (let i=1; i<s.length; i+=2) {
            for (let key of Object.keys(obj)) {
                if (key == max[0]) {
                    continue;
                }
                else if(obj[key] > 0) {
                    ans[i] = key;
                    obj[key]--;
                    break;
                }
            }
    }
    return ans.join('');
};