/**
 * @param {string} s
 * @return {number}
 */
/* 3 hard point
 1. strip all white spaces 
 2. get each number and operators
 3. calculate with order
*/
var calculate = function(s) {
    let stripped = s.replaceAll(' ', '');
    // 3 pass, first
    let numStart = -1;
    let stk = [];
    let secondRound = [];
    //console.log(stripped);
    for (let i=0; i<stripped.length; i++) {
        if (
            stripped[i] == '+'
            || stripped[i] == '-'
            || stripped[i] == '*'
            || stripped[i] == '/'
        ) {
            let num = parseInt(stripped.slice(numStart+1,i));
            secondRound.push(num);
            secondRound.push(stripped[i]);
            numStart = i;
        }
    }
    let num = parseInt(stripped.slice(numStart+1,stripped.length));
    secondRound.push(num);
    // console.log('secondRound', secondRound);
    // 3 pass, second
    let thirdRound = [];
    for (let i=1; i<secondRound.length; i++) {
        if (secondRound[i] == '*') {
            secondRound[i+1] = secondRound[i-1]*secondRound[i+1];
            i++;
        }
        else if (secondRound[i] == '/') {
            secondRound[i+1] = Math.floor(secondRound[i-1]/secondRound[i+1]);
            i++;
        }
        else if (secondRound[i] == '+'
                || secondRound[i] == '-') {
            thirdRound.push(secondRound[i-1]);
            thirdRound.push(secondRound[i]);
        }
    }
    if (secondRound[secondRound.length-1] != thirdRound[thirdRound.length-1]) {
        thirdRound.push(secondRound[secondRound.length-1]);
    }
    // console.log('thirdRound', thirdRound);
    // 3pass, third
    for (let i=1; i<thirdRound.length; i++) {
        if (thirdRound[i] == '+') {
            thirdRound[i+1] = thirdRound[i-1]+thirdRound[i+1];
            i++;
        }
        else if (thirdRound[i] == '-') {
            thirdRound[i+1] = thirdRound[i-1]-thirdRound[i+1];
            i++;
        }
    }
    return thirdRound.pop();
};