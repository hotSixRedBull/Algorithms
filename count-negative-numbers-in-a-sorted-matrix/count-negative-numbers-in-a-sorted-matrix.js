/**
 * @param {number[][]} grid
 * @return {number}
 */
var countNegatives = function(grid) {
    let res = 0;
    for (let r=0; r<grid.length; r++) {
        for (let c=0; c<grid[r].length; c++) {
            if (grid[r][c] < 0) {
                res += grid[r].length-c;
                break;
            }
        }
    }
    return res;
};