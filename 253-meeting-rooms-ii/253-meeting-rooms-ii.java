class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                if (i1[1] != i2[1]) {
                    return i1[1] > i2[1] ? 1 : -1;
                }
                return i1[0] > i2[0] ? 1 : -1;
            }
        });
        // System.out.println("sorted: ");
        // for (int j=0;j<intervals.length; j++) {
        //     System.out.println("  "+Arrays.toString(intervals[j]));
        // }
        // System.out.println("");
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                if (i1[1] != i2[1]) {
                    return i1[1] < i2[1] ? 1 : -1;
                }
                return i1[0] < i2[0] ? 1 : -1;
            }
        });
        pq.add(intervals[0]);
        for (int i=1; i<intervals.length; i++) {
            int[] cur = pq.poll();
            if (cur[1] <= intervals[i][0]) {
                cur = intervals[i];
                pq.add(cur);
            }
            else {
                Stack<int[]> stk = new Stack<>();
                stk.push(cur);
                while (pq.size() > 0) {
                    int[] subCur = pq.poll();
                    if (subCur[1] <= intervals[i][0]) {
                        subCur = intervals[i];
                        pq.add(subCur);
                        break;
                    }
                    stk.push(subCur);
                }
                if(pq.size() == 0) {
                    pq.add(intervals[i]);
                }
                while (stk.size() > 0) {
                    pq.add(stk.pop());
                }
            }
            // for (int j=0;j<pq.size(); j++) {
            //     int[][] arr = pq.toArray(new int[0][0]);
            //     System.out.println(Arrays.toString(arr[j]));
            // }
            // System.out.println("<<end>>");
        }
        return pq.size();
    }
}