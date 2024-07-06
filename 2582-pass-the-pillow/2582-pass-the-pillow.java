class Solution {
    public int passThePillow(int n, int time) {
        int lineCnt = 0;
        if (time > n-1) {
            lineCnt = (int) Math.floor(time/(n-1));
            time = time%(n-1);
        }
        if (lineCnt % 2 == 0) {
            return time+1;
        }
        else {
            return n-time;
        }
    }
}