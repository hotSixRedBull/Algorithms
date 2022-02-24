class Solution {
    public double average(int[] salary) {
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0;
        for (int sal : salary) {
            sum += sal;
            min = Math.min(min, sal);
            max = Math.max(max, sal);
        }
        return (sum-min-max)/(salary.length-2);
    }
}