/** 
 * Forward declaration of guess API.
 * @param {number} num   your guess
 * @return 	            -1 if num is lower than the guess number
 *			             1 if num is higher than the guess number
 *                       otherwise return 0
 * var guess = function(num) {}
 */

/**
 * @param {number} n
 * @return {number}
 */
var guessNumber = function(n) {
    let left = 1;
    let right = n;
    let guessResult = -1;
    while (guessResult != 0) {
        let mid = Math.floor(left+((right-left)/2));
        guessResult = guess(mid);
        if (guessResult == 1) {
            left = mid+1;
        }
        else if (guessResult == -1) {
            right = mid-1;
        }
        else {
            left = mid;
            right = mid;
            break;
        }
    } 
    return left;
};