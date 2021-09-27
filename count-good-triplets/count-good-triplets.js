/**
 * @param {number[]} arr
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
var countGoodTriplets = function(arr, a, b, c) {
    let p1=0;
    let p2=1;
    let p3=2;
    let res=0;
    while (p1 < arr.length-2) {
        //console.log(p1,p2,p3);
        if (Math.abs(arr[p1]-arr[p2]) <= a
            && Math.abs(arr[p2]-arr[p3]) <= b
            && Math.abs(arr[p1]-arr[p3]) <= c) {
            res++;
        }
        if (p2 >= arr.length-2) {
                p1++;
                p2 = p1+1;
                p3 = p2+1;            
        }
        else if (p3 >= arr.length-1) {
            p2++;
            p3 = p2+1;
        }
        else {
            p3++;
        }
    }
    return res;
};