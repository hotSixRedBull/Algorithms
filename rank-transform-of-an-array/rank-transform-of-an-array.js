/**
 * @param {number[]} arr
 * @return {number[]}
 */
var arrayRankTransform = function(arr) {
    let sortedArr = arr.slice(0, arr.length);
    sortedArr.sort((a,b)=>a-b);
    //console.log(`sortedArr: ${sortedArr}`);
    let filtered = [sortedArr[0]];
    for (let i=1; i<sortedArr.length; i++) {
        if (sortedArr[i] != sortedArr[i-1]) {
            filtered.push(sortedArr[i]);
        }
    }
    sortedArr = filtered;
    
    function findIndex(val) {
        let left=0;
        let right=sortedArr.length-1;
        //console.log(`val: ${val}`);
        while (left < right) {
            let mid = Math.floor(left + (right-left)/2);
            //console.log(`mid: ${mid}, sortedArr[mid]: ${sortedArr[mid]}`);
            if (sortedArr[mid] == val) {
                return mid;
            }
            else if (sortedArr[mid] < val) {
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        //console.log(`left: ${left}, right: ${right}`);
        return left;
    }
    for (let i=0;i<arr.length;i++) {
        arr[i] = findIndex(arr[i])+1;
    }
    return arr;
};