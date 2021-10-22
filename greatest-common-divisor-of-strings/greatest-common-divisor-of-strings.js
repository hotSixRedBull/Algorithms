/**
 * @param {string} str1
 * @param {string} str2
 * @return {string}
 */
var gcdOfStrings = function(str1, str2) {
    //
    let length = Math.min(str1.length, str2.length);
    let tmp = '';
    let ans = '';
    function isValid(str) {
        let ret = true;
        // check division on str1
        if (str1.length % str.length == 0) {
            for (let i=0; i<str1.length; i+= str.length) {
                if (str != str1.substring(i, i+str.length)) {
                    ret = false;
                    break;
                }
            }    
        }
        else {
            ret = false;
        }
        // check division on str2
        if (str2.length % str.length == 0) {
            for (let i=0; i<str2.length; i+= str.length) {
                if (str != str2.substring(i, i+str.length)) {
                    ret = false;
                    break;
                }
            }    
        }
        else {
            ret = false;
        }
        return ret;
    }
    // make largest gcd
    for (let i=0; i<length; i++) {
        if (str1[i] == str2[i]) {
            tmp += str1[i];
            if (isValid(tmp)) {
                ans = tmp;
            }
        }
        else {
            break;
        }
    }
    
    return ans;
    
};