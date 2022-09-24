class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> answer = new ArrayList();
        int intervalIndex = 0;
        int removeFront = toBeRemoved[0];
        int removeEnd = toBeRemoved[1];
        while (intervalIndex < intervals.length) {
            if (removeFront > intervals[intervalIndex][1]) {
                answer.add(new ArrayList(List.of(intervals[intervalIndex][0],intervals[intervalIndex][1])));
            }
            else if (removeEnd < intervals[intervalIndex][0]) {
                answer.add(new ArrayList(List.of(intervals[intervalIndex][0],intervals[intervalIndex][1])));
            }
            else if (intervals[intervalIndex][0] <= removeFront
                    && removeEnd <= intervals[intervalIndex][1]) {
                if (intervals[intervalIndex][0] < removeFront) {
                    answer.add(new ArrayList(List.of(intervals[intervalIndex][0], removeFront)));
                }
                if (removeEnd < intervals[intervalIndex][1]) {
                    answer.add(new ArrayList(List.of(removeEnd, intervals[intervalIndex][1])));
                }
            }
            else if (intervals[intervalIndex][0] <= removeFront
                    && removeFront <= intervals[intervalIndex][1]) {
                int start = Math.min(intervals[intervalIndex][0], removeFront);
                int end = Math.max(intervals[intervalIndex][0], removeFront);
                answer.add(new ArrayList(List.of(start, end)));
            }
            else if (intervals[intervalIndex][0] <= removeEnd
                    && removeEnd <= intervals[intervalIndex][1]) {
                int start = Math.min(intervals[intervalIndex][1], removeEnd);
                int end = Math.max(intervals[intervalIndex][1], removeEnd);
                answer.add(new ArrayList(List.of(start, end)));
            }
            // else if (removeFront <= intervals[intervalIndex][0]
            //         && intervals[intervalIndex][1] <= removeEnd) {
            //     intervalIndex++;
            // }
            // System.out.println("1: "+answer);
            intervalIndex++;
        }
        
        return answer;
    }
}