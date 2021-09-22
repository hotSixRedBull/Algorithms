/**
 * Definition for isBadVersion()
 * 
 * @param {integer} version number
 * @return {boolean} whether the version is bad
 * isBadVersion = function(version) {
 *     ...
 * };
 */

/**
 * @param {function} isBadVersion()
 * @return {function}
 */
var solution = function(isBadVersion) {
    /**
     * @param {integer} n Total versions
     * @return {integer} The first bad version
     */
    return function(n) {
        let left = 0;
        let right = n;
        let pivot = Math.floor((left+right)/2);
        while (left < right) {
            pivot = Math.floor((left+right)/2);
            if (isBadVersion(pivot)) {
                right = pivot-1;
            }
            else {
                left = pivot+1;
            }
            console.log(left, right)
        }
        return isBadVersion(left) ? left : left+1;
    };
};