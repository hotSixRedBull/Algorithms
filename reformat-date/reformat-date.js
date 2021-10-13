/**
 * @param {string} date
 * @return {string}
 */
var reformatDate = function(date) {
    let arr = date.split(' ');
    let ans = [];
    ans.push(arr[2]);
    switch (arr[1]) {
        case "Jan":
            ans.push("01");
            break;
        case "Feb":
            ans.push("02");
            break;
        case "Mar":
            ans.push("03");
            break;
        case "Apr":
            ans.push("04");
            break;
        case "May":
            ans.push("05");
            break;
        case "Jun":
            ans.push("06");
            break;
        case "Jul":
            ans.push("07");
            break;
        case "Aug":
            ans.push("08");
            break;
        case "Sep":
            ans.push("09");
            break;
        case "Oct":
            ans.push("10");
            break;
        case "Nov":
            ans.push("11");
            break;
        case "Dec":
            ans.push("12");
            break;
    }
    let day = arr[0].slice(0,-2);
    ans.push(arr[0].length == 3 ? '0'+day: day);
    return ans.join('-');
};