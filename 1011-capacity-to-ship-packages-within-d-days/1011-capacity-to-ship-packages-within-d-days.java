class Solution {
    int sum = 0;
    public int shipWithinDays(int[] weights, int days) {
        for (int weight : weights) {
            sum += weight;
        }
        
        int lo = sum/days;
        int hi = sum;
        while (lo <= hi) {
            int mid = lo - (lo - hi) / 2;
            if (canBeDelivered(weights, days, mid)) {
                hi = mid-1;
            }
            else {
                lo = mid+1;
            }
        }
        return lo;
    }
    public boolean canBeDelivered(int[] weights, int day, int max) {
        int sumCopy = sum;
        int cur = 0;
        for (int weight : weights) {
            // System.out.println(">> weight : "+weight);
            // System.out.println(">> cur : "+cur);
            // System.out.println(">> sumCopy : "+sumCopy);
            // System.out.println(">> day : "+day);
            if (weight > max) {
                return false;
            }
            if (cur + weight == max) {
                sumCopy -= max;
                cur = 0;
                day--;
                if (day <= 0) {
                    break;
                }
            }
            else if (cur + weight > max) {
                sumCopy -= cur;
                cur = weight;
                day--;
                if (day <= 0) {
                    break;
                }
            }
            else {
                cur += weight;
            }
        }
        if (cur > 0) {
            sumCopy -= cur;
            cur = 0;
            day--;
        }
        boolean res = sumCopy == 0 && day >= 0;
        // System.out.println("max : "+max);
        // System.out.println("sumCopy : "+sumCopy);
        // System.out.println("day : "+day);
        // System.out.println("cur : "+cur);
        // System.out.println("result : "+res);
        return res;
    }
}