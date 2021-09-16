/**
 * @param {number[][]} logs
 * @return {number}
 */
var maximumPopulation = function(logs) {
    let candidate = [];
    function getPopulation(year) {
        let cnt = 0;
        for (let [birth, death] of logs) {
            if (birth <= year && year < death) cnt++;
        }
        console.log(`${year} is ${cnt}`)
        return cnt;
    }
    for (let [birth, death] of logs) {
        candidate.push(birth);
    }
    let maxPop = 0;
    let res = candidate[0];
    for (let birth of candidate) {
        let curPop = getPopulation(birth)
        if(maxPop < curPop || (birth <= res && maxPop == curPop)) {
            maxPop = curPop;
            res = birth;
        }
    }
    return res;
};