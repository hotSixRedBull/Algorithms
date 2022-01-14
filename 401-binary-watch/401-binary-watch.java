class Solution {
    public List<String> answer;
    public Set<String> answerSet;
    public void recursive(int cur, int left, int timeNum) {
        // System.out.println("cur: "+cur);
        // System.out.println(Integer.toBinaryString(timeNum));
        if (cur > 10) {
            return;
        }
        if (left == 0) {
            if (left > 0) {
                return;
            }
            int hourFilter = 0b1111000000;
            int minuteFilter = 0b0000111111;
            int hour = timeNum & hourFilter;
            hour >>>= 6;
            int minute = timeNum & minuteFilter;
            // System.out.println("hour: "+hour);
            // System.out.println("minute: "+minute);
            if (hour > 11 || minute > 59) {
                return;
            }
            
            String str = "";
            if (minute < 10) {
                str = String.format("%d:0%d", hour, minute);
            }
            else {
                str = String.format("%d:%d", hour, minute);
            }
            // System.out.println(str);
            // System.out.println(Integer.toBinaryString(timeNum));
            if (!this.answerSet.contains(str)) {
                this.answer.add(str);
                this.answerSet.add(str);
            }
        }
        else {
            if (left > 0) {
                int put = 1;
                put <<= cur;
                if ((put & timeNum) > 0) {
                    return;
                }
                recursive(cur+1, left-1, timeNum ^ put);
            }
            recursive(cur+1, left, timeNum);
        }
    }
    public List<String> readBinaryWatch(int turnedOn) {
        this.answer = new ArrayList<>();
        this.answerSet = new HashSet<>();
        recursive(0, turnedOn, 0);
        if (turnedOn > 0) {
            recursive(0, turnedOn-1, 0b1000000000);
        }
        return this.answer;
    }
}