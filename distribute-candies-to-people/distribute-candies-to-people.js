/**
 * @param {number} candies
 * @param {number} num_people
 * @return {number[]}
 */
var distributeCandies = function(candies, num_people) {
    let ans = Array(num_people).fill(0);
    let prefix = 0;
    let acc = 0;
    let oneRound = num_people*(num_people+1)/2;
    let calc = acc+oneRound;
    let round = 0;
    while (calc < candies) {
        round++;
        prefix += num_people;
        acc += prefix*num_people;
        calc = acc+oneRound*(round+1);
    }
    //console.log('round: ', round);
    if (round > 0) { 
        for (let i=0; i<num_people && candies > 0; i++) {
            let need = (round*(round-1)/2)*num_people+(i+1)*(round);
            ans[i] = need;
            candies -= need;
        }
    }
    //console.log('ans: ', ans);
    for (let i=0; i<num_people && candies > 0; i++) {
        let need = round*num_people+(i+1) < candies ? round*num_people+(i+1) : candies;
        ans[i] += need;
        candies -= need;
    }
    //console.log('ans2: ', ans);
    return ans;
};