/**
 * @param {number[]} arr
 * @return {number[][]}
 */
var minimumAbsDifference = function(arr) {
    let min = Number.MAX_SAFE_INTEGER;
    let p1 = 0;
    let p2 = 1;
    let map = {};
    arr.sort((a,b) => a-b);
    while (p1 < arr.length-1) {
        let calc = Math.abs(arr[p1]-arr[p2]);
        if (min > calc) {
            min = calc;
        }
        if (calc == min) {
            if (!!map[calc]) {
                map[calc].push([arr[p1], arr[p2]]);
            }
            else {
                map[calc] = [[arr[p1], arr[p2]]];
            }
        }
        if (p2 == arr.length-1 || calc > min) {
            p1++;
            p2 = p1+1;
        }
        else {
            p2++;
        }
    }
    return map[min];
};