class Solution {
    public boolean judgeSquareSum(int c) {
        HashMap<Integer, Long> map = new HashMap();
        for (long i=0; i<=c; i++) {
            long square = i*i;
            if (square > c) {
                break;
            }
            map.put((int)i, square);
        }
        int left = 0;
        int right = map.size()-1;
        while (left <= right) {
            long sum = map.get(left) + map.get(right);
            if (sum == c) {
                return true;
            }
            if (sum < c) {
                left++;
            }
            else {
                right--;
            }
        }
        return false;
    }
}