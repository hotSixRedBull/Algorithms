class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                return arg0[1] - arg1[1];
            }
        };
        Arrays.sort(slots1, comp);
        Arrays.sort(slots2, comp);
        List<Integer> ans = new ArrayList();
        int i=0;
        int j=0;
        while (i < slots1.length
              && j < slots2.length) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            int diff = end - start;
            if (diff >= duration) {
                ans.add(start);
                ans.add(start+duration);
                break;
            }
            if (slots1[i][1] <= slots2[j][1]) {
                i++;
            }
            else {
                j++;
            }
            
        }
        return ans;
    }
}

/*
[[10,12],[15, 25]]
[[0,100]]
8
*/