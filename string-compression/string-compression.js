/**
 * @param {character[]} chars
 * @return {number}
 */
var compress = function(chars) {
    let res = '';
    let prev = chars[0];
    let consecutive = 1;
    for (let i=1;i<chars.length;i++) {
        if (chars[i] == prev) {
            consecutive++;
        }
        else {
            res += consecutive == 1 ? prev : prev + consecutive.toString();
            consecutive = 1;
            prev = chars[i];
        }
    }
    res += consecutive == 1 ? prev : prev + consecutive.toString();
    for (let i = 0; i < res.length; i++) {
        if(res[i] != chars[i]) {
            chars[i] = res[i];
        }
    }
    chars.splice(res.length);
};