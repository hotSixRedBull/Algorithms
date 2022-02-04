class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for (int i=0; i<startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}