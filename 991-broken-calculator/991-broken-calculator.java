class Solution {
    public int brokenCalc(int startValue, int target) {
        int cnt = 0;
        while (startValue != target) {
            // System.out.println(String.format("target: %d", target));
            while (target % 2 == 0
                  && startValue < target) {
                target /= 2;
                cnt++;
            }
            if (target == startValue) {
                return cnt;
            }
            if (startValue > target) {
                cnt += startValue-target;
                target = startValue;
            }
            else {
                target += 1;
                cnt++;
            }
            if (target == startValue) {
                return cnt;
            }
        }
        return 0;
    }
}