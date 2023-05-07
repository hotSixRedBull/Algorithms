class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int n = obstacles.length;
        List<int[]> li = new ArrayList();
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            int ob = obstacles[i];
            int[] cur = new int[]{ob, i};
            if (li.size() > 0) {
                int[] last = li.get(li.size()-1);
                if (last[0] > ob) {
                    int index = Collections.binarySearch(li, cur, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
                    if (index < 0) {
                        index++;
                        index *= -1;
                    }
                    li.set(index, cur);
                }
                else {
                    li.add(cur);
                }
            }
            else {
                li.add(cur);
            }
            // System.out.println(li);
            result[i] = Collections.binarySearch(li, cur, (a,b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0])+1;
        }
        return result;
        
    }
}

/*
LIS on each index?

*/