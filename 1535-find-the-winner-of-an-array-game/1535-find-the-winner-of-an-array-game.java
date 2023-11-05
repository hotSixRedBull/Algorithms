class Solution {
    public int getWinner(int[] arr, int k) {
        int n = arr.length;
        int cur = arr[0];
        Queue<Integer> q = new ArrayDeque();
        for (int i=1; i<n; i++) {
            q.add(arr[i]);
        }
        int consecutive_win = 0;
        while (consecutive_win < k && consecutive_win < n) {
            int versus = q.poll();
            if (cur > versus) {
                consecutive_win++;
                q.add(versus);
            }
            else {
                q.add(cur);
                cur = versus;
                consecutive_win=1;
            }
        }
        return cur;
    }
}