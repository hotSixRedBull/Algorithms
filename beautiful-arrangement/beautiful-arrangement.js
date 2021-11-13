/**
 * @param {number} n
 * @return {number}
 */
var countArrangement = function(n) {
    let cnt = 0;
    function chkCondition(arr) {
        for (let i=0; i<arr.length; i++) {
            if ((i+1) % arr[i] != 0 && arr[i] % (i+1) != 0) {
                return false;
            }
        }
        return true;
    }
    function permutationRecursive(curPos, permArr, visited) {
        //console.log('curPos', curPos, 'permArr', permArr, 'visited', visited);
        if (permArr.length == n) {
            //console.log(permArr);
            if (chkCondition(permArr)) {
                cnt++;
            }
            return;
        }
        for (let i=1; i<=n; i++) {
            if (visited[i] == false && (i % (curPos+1) == 0 || (curPos+1) % i == 0)) {
                visited[i] = true;
                permArr.push(i);
                permutationRecursive(curPos+1, permArr, visited);
                visited[i] = false;
                permArr.pop();
            }
        }
    }
    permutationRecursive(0, [], Array(n+1).fill(false));
    return cnt;
};