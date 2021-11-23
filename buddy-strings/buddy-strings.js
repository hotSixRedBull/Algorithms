/**
 * @param {string} s
 * @param {string} goal
 * @return {boolean}
 */
var buddyStrings = function(s, goal) {
    let diff = 0;
    let arr = [];
    let obj = {};
    let hasDuplicate = false;
    for (let i=0; i<s.length; i++) {
        if (s[i] != goal[i]) {
            diff++;
            arr.push(i);
        }
        if (obj[s[i]] == undefined) {
            obj[s[i]] = 1;
        }
        else {
            obj[s[i]]++;
            hasDuplicate = true;
        }
    }
    //console.log(diff)
    if (hasDuplicate && diff == 0) {
        return true;
    }
    if (diff != 2) {
        return false;
    }
    else {
        s = s.split('');
        [s[arr[0]], s[arr[1]]] = [s[arr[1]], s[arr[0]]];
        return s.join('') == goal;
    }
};