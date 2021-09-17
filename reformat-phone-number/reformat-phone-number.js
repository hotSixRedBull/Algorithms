/**
 * @param {string} number
 * @return {string}
 */
var reformatNumber = function(number) {
    number = number.replaceAll(' ','').replaceAll('-','');
    let res = '';
    if (number.length%3 == 0) {
        let i;
        for (i=0; i<number.length; i+=3) {
            for (let j=0; j<3; j++) {
                res += number[i+j];
            }
            res += '-';
        }
    }
    else {
        let i;
        let suffix = number.length%3 == 2 ? 2 : 4;
        for (i=0; i<number.length-suffix; i+=3) {
            for (let j=0; j<3; j++) {
                res += number[i+j];
            }
            res += '-';
        }
        for (; i<number.length; i+=2) {
            for (let j=0; j<2; j++) {
                res += number[i+j];
            }
            res += '-';
        }
    }
    res = res.substring(0, res.length-1);
    return res;
};