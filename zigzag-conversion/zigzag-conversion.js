/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function(s, numRows) {
    let zigzag = [];
    let nextIndex = 0;
    let nextDirectionIncreasing = true;
    for (let i=0; i<numRows; i++) {
        zigzag.push([]);
    }
    //console.log(zigzag);
    for (let i=0; i<s.length; i++) {
        zigzag[nextIndex].push(s[i]);
        //console.log(`zigzag[nextIndex]: ${zigzag[nextIndex]}`)
        if (nextIndex == numRows-1 && nextDirectionIncreasing == true) {
            nextDirectionIncreasing = !nextDirectionIncreasing;
        }
        else if(nextIndex == 0 && nextDirectionIncreasing == false) {
            nextDirectionIncreasing = !nextDirectionIncreasing;
        }
        if (nextDirectionIncreasing && nextIndex < numRows-1) {
            nextIndex++;
        }
        else if (nextIndex > 0){
            nextIndex--;
        }
    }
    let ans = '';
    for (let i=0; i<numRows; i++) {
        ans += zigzag[i].join('');
    }
    return ans;
};