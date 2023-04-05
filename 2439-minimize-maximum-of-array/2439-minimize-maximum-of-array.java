class Solution {
    Stack<double[]> stk;
    public Solution() {
        stk = new Stack();
    }
    
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        double sum = nums[0];
        double num = 1;
        for (int i=1; i<n; i++) {
            if (nums[i] < nums[i-1]) {
                updateAvg(sum, num);
                sum = 0;
                num = 0;
            }
            sum += nums[i];
            num++;
        }
        updateAvg(sum, num);
        int max = 0;
        while(stk.size() > 0) {
            double[] top = stk.pop();
            max = Math.max(max, (int)Math.ceil(top[0]/top[1]));
        }
        return max;
    }
    public void updateAvg(double sum, double num) {
        int avg = (int) Math.ceil(sum/num);
        while (stk.size() > 0) {
            double[] top = stk.peek();
            int topAvg = (int) Math.ceil(top[0]/top[1]);
            if (topAvg > avg) {
                break;
            }
            stk.pop();
            sum += top[0];
            num += top[1];
            avg = (int) Math.ceil(sum/num);
        }
        stk.push(new double[]{sum, num});
        // System.out.println(String.format("stk: %s", stk));
    }
}