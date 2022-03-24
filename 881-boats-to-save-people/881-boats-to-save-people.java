class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int lo=0;
        int hi=people.length-1;
        int cnt = 0;
        while (lo <= hi) {
            if (lo == hi) {
                cnt++;
                break;
            }
            else if (people[lo]+people[hi] <= limit) {
                cnt++;
                lo++;
                hi--;
            }
            else if (people[hi] <= limit) {
                cnt++;
                hi--;
            }
        }
        return cnt;
    }
}