/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[][]}
 */
var fourSum = function(nums, target) {
    let arr = nums.slice();
    arr.sort((a,b) => a-b);
    let consecutive = 0;
    let prev = arr[0];
    let filteredNums = [];
    for (let i=0; i<arr.length; i++) {
        if (arr[i] == prev) {
            consecutive++;
        }
        else {
            consecutive = 0; 
        }
        if (consecutive < 5) {
            filteredNums.push(arr[i]);
        }
    }
    
    let pArr = [0, 1, 2, 2];
    let ans = new Set();
    let obj = {};
    while (pArr[0] < filteredNums.length-3) {
        if (pArr[1] == filteredNums.length-2) {
            pArr[0]++;
            pArr[1] = pArr[0]+1;
            pArr[2] = pArr[1]+1;
            pArr[3] = pArr[2]+1;
        }
        else if(pArr[2] == filteredNums.length-1) {
            pArr[1]++;
            pArr[2] = pArr[1]+1;
            pArr[3] = pArr[2]+1;
        }
        else if(pArr[3] == filteredNums.length) {
            pArr[2]++;
            pArr[3] = pArr[2]+1;
        }
        else {
            pArr[3]++;
        }
        let sum = filteredNums[pArr[0]]+filteredNums[pArr[1]]+filteredNums[pArr[2]]+filteredNums[pArr[3]];
        if (target == sum) {
            let participant = [
                filteredNums[pArr[0]],
                filteredNums[pArr[1]],
                filteredNums[pArr[2]],
                filteredNums[pArr[3]]
            ].sort((a,b) => a-b);
            let key = participant.join(',');
            if (obj[key] == undefined) {
                ans.add(participant);
                obj[key] = 1;
            }
        }
    }
    return Array.from(ans);
};