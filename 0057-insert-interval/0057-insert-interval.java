class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> li = new ArrayList();
        for (int[] i : intervals) {
            if (i[1] < newInterval[0]
               || newInterval[0] == -1) {
                li.add(i);
                continue;
            }
            else if (newInterval[0] <= i[1]) {
                if (newInterval[1] < i[0]) {
                    li.add(new int[]{newInterval[0], newInterval[1]});
                    newInterval[0] = -1;
                    li.add(i);
                    continue;
                }
                newInterval[0] = Math.min(i[0], newInterval[0]);
                newInterval[1] = Math.max(i[1], newInterval[1]);
                continue;
            }
        }
        if (newInterval[0] != -1) {
            li.add(newInterval);
        }
        int[][] ans = new int[li.size()][2];
        for (int i=0; i<ans.length; i++) {
            ans[i] = li.get(i);
        }
        return ans;
    }
}

/*
[]
[5,7]

[[1,5]]
[6,8]
*/