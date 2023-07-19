class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0]-b[0] : a[1]-b[1]);
        // for (int[] a : intervals){
        //     System.out.print(Arrays.toString(a));
        // }
        // System.out.println();
        int n = intervals.length;
        int[] prev = intervals[0];
        int len = 1;
        for (int i=1; i<n; i++) {
            if (prev[1] <= intervals[i][0]) {
                prev = intervals[i];
                len++;
            }
        }
        return n-len;
    }
}

/*
[[1,2],[2,3],[3,4],[1,3]]
[[1,2],[1,2],[1,2]]
[[1,2],[2,3]]
[[1,2]]
[[1,2],[1,3],[1,4],[2,3],[2,4]]
[[1,100],[11,22],[1,11],[2,12]]
[[-52,31],[-73,-26],[82,97],[-65,-11],[-62,-49],[95,99],[58,95],[-31,49],[66,98],[-63,2],[30,47],[-40,-26]]
*/