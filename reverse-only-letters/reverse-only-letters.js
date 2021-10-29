/**
 * @param {string} s
 * @return {string}
 */
var reverseOnlyLetters = function(s) {
    let sArr = s.split('');
    let left = 0;
    let right = s.length-1;
    // let aCharCode = 'a'.charCodeAt(0);
    // let zCharCode = 'z'.charCodeAt(0);
    // let ACharCode = 'A'.charCodeAt(0);
    // let ZCharCode = 'Z'.charCodeAt(0);
    // console.log(aCharCode, zCharCode, ACharCode, ZCharCode);
    while (left < right) {
        let leftCharCode = s.charCodeAt(left);
        while (leftCharCode < 65 || (leftCharCode > 90 && leftCharCode < 97) || leftCharCode > 122) {
            leftCharCode = s.charCodeAt(++left);
        }
        let rightCharCode = s.charCodeAt(right);
        while (rightCharCode < 65 || (rightCharCode > 90 && rightCharCode < 97) || rightCharCode > 122) {
            rightCharCode = s.charCodeAt(--right);
        }
        if (left < right) {
            [sArr[left], sArr[right]] = [sArr[right], sArr[left]];
        }
        left++;
        right--;
    }
    return sArr.join('');
};