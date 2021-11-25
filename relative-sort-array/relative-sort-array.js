/**
 * @param {number[]} arr1
 * @param {number[]} arr2
 * @return {number[]}
 */
var relativeSortArray = function(arr1, arr2) {
    let cnt1 = {};
    let cnt2 = {};
    let rest = [];
    for (let i=0; i<arr2.length; i++) {
        cnt2[arr2[i]] = 1;
    }
    for (let i=0; i<arr1.length; i++) {
        if (cnt2[arr1[i]] != undefined) {
            if (cnt1[arr1[i]] == undefined) {
                cnt1[arr1[i]] = 1;
            }
            else {
                cnt1[arr1[i]]++;
            }
        }
        else {
            rest.push(arr1[i]);
        }
    }
    
    let result = [];
    for (let i=0; i<arr2.length; i++) {
        while (cnt1[arr2[i]] > 0) {
            cnt1[arr2[i]]--;
            result.push(arr2[i]);
        }
    }
    rest.sort((a, b) => a-b);
    result = [...result, ...rest];
    return result;
};