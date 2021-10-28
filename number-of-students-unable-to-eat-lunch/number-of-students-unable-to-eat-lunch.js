/**
 * @param {number[]} students
 * @param {number[]} sandwiches
 * @return {number}
 */
var countStudents = function(students, sandwiches) {
    let peoplePrefix = 0;
    for (let i=0; i<students.length; i++) {
        let cur = sandwiches.shift();
        let cnt = students.length;
        while (students[i] != cur && i < cnt) {
            students.push(students[i]);
            i++;
            //console.log(students);
        }
        //console.log(`${cur} == ${students[i]}`)
        if (cur != students[i]) {
            sandwiches.push(0);
            break;
        }
    }
    return sandwiches.length;
};