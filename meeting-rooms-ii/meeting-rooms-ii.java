class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (m1, m2) -> m1[0]-m2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> m1[1]-m2[1]);
        pq.add(intervals[0]);
        for (int i=1; i<intervals.length; i++) {
            int[] cur = pq.poll();
            if (cur[1] > intervals[i][0]) {
                pq.add(cur);
            }
            pq.add(intervals[i]);
        }
        return pq.size();
    }
}