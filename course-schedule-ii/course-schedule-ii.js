/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
var findOrder = function(numCourses, prerequisites) {
    let obj = {};
    
    function removePrecedence(object, course) {
        delete object[course];
        let list = Object.keys(object);
        for (let i=0; i<list.length; i++) {
            if (object[list[i]] != undefined 
                && object[list[i]][course] != undefined) {
                delete object[list[i]][course];
            }
        }
    }
    for (let i=0; i<numCourses; i++) {
        obj[i] = {};
    }
    for (let i=0; i<prerequisites.length; i++) {
        obj[prerequisites[i][0]][prerequisites[i][1]] = true;
    }
    let ans = [];
    let cnt = 0;
    let list = Object.keys(obj);
    do {
        cnt = 0;
        //console.log(`[BEFORE] obj: ${JSON.stringify(obj)}, ans: ${ans}`);
        list = Object.keys(obj);
        for (let i=0; i<list.length; i++) {
            //console.log(`Object.keys(obj[${i}]).length: ${list.length}`)
            if (Object.keys(obj[list[i]]).length == 0) {
                //console.log(`[REMOVE] ${i}th course`)
                cnt++;
                ans.push(list[i]);
                removePrecedence(obj, list[i]);
            }
        }
        //console.log(`[AFTER] obj: ${JSON.stringify(obj)}, ans: ${ans}`);
    } while(cnt > 0 && list.length > 0);
    if (ans.length == numCourses) {
        return ans;
    }
    else {
        return [];
    }
};