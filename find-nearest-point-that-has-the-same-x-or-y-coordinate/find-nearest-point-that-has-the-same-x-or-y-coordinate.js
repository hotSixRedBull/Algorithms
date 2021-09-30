/**
 * @param {number} x
 * @param {number} y
 * @param {number[][]} points
 * @return {number}
 */
var nearestValidPoint = function(x, y, points) {
    let resIndex = -1;
    let resDist = Number.MAX_SAFE_INTEGER;
    for (let i=0; i<points.length; i++) {
        if (x == points[i][0]) {
            let dist = Math.abs(y-points[i][1]);
            if (dist < resDist) {
                resIndex = i;
                resDist = dist;
            }
        }
        else if (y == points[i][1]) {
            let dist = Math.abs(x-points[i][0]);
            if (dist < resDist) {
                resIndex = i;
                resDist = dist;
            }
        }
    }
    
    return resIndex;
};