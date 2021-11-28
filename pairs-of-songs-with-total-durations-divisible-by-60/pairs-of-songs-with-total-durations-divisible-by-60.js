/**
 * @param {number[]} time
 * @return {number}
 */
var numPairsDivisibleBy60 = function(time) {
    let obj = {};
    let cnt = 0;
    for (let i=0; i<time.length; i++) {
        let remainder = time[i] % 60;
        let target = remainder == 0 ? obj['0'] : obj[60-remainder];
        if (target != undefined && target > 0) {
            if (remainder != 0) {
                //console.log(60-remainder, time[i], target);
                cnt+=target;
            }
        }
        if (obj[remainder] == undefined) {
            obj[remainder] = 1;
        }
        else {
            obj[remainder]++;
        }
    }
    //handle 0 cases separately
    if (obj['0'] > 1) {
        //console.log(obj['0'], cnt);
        cnt += obj['0']*(obj['0']-1)/2;
    }
    return cnt;
};