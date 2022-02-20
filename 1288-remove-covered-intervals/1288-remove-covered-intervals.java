class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
            public int compare(int[] arg0, int[] arg1) {
                if (arg0[1] < arg1[1]) {
                    return 1;
                }
                else if (arg0[1] > arg1[1]) {
                    return -1;
                }
                else {
                    if (arg0[0] < arg1[0]) {
                        return -1;
                    }
                    else if (arg0[0] > arg1[0]) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        });
        
        List<List<Integer>> list = new ArrayList();
        for (int[] interval : intervals) {
            list.add(Arrays.asList(interval[0], interval[1]));
        }
        // System.out.println("list: "+list);
        
        for (int index = 0; index<list.size(); index++) {
            List<List<Integer>> filtered = new ArrayList();
            for (int j = 0; j <= index; j++) {
                filtered.add(list.get(j));
            }
            for (int j = index+1; j<list.size(); j++) {
                // System.out.println("j: "+j);
                if (list.get(index).get(0) <= list.get(j).get(0)
                    && list.get(index).get(1) >= list.get(j).get(1)) {
                        continue;
                }
                filtered.add(list.get(j));
            }
            list = filtered;
        }
        
        return list.size();
    }
}

/*
[[1,4],[4,7],[3,6]]
*/