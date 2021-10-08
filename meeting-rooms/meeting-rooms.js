/**
 * @param {number[][]} intervals
 * @return {boolean}
 */
var canAttendMeetings = function(intervals) {
    intervals.sort((a, b) => {
        if (a[1] == b[1]) {
            return a[0] - b[0];
        }
        return a[1] - b[1];
    });
    for (let i=0; i<intervals.length-1;i++) {
        if (intervals[i][1] > intervals[i+1][0]) {
            return false;
        }
    }
    return true;
};