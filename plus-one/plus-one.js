/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function(digits) {
    let carry = 1;
    for (let i=digits.length-1;i > -1;i--) {
        let cur = digits[i];
        let calc = cur + carry;
        carry = 0;
        if (calc > 9) {
            calc = 0;
            carry = 1;
        }
        if (calc == digits[i]) {
            break;
        }
        digits[i] = calc;
    }
    if (carry == 1) {
        digits.unshift(1);
    }
    return digits;
};