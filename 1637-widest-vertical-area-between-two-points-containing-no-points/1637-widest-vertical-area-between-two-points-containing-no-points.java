class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Set<Integer> x = new HashSet();
        int n = points.length;
        for (int i=0; i<n; i++) {
            x.add(points[i][0]);
        }
        
        List<Integer> xList = new ArrayList(x);
        Collections.sort(xList);
        int max = 0;
        for (int i=0; i<xList.size()-1; i++) {
            max = Math.max(max, xList.get(i+1) - xList.get(i));
        }
        return max;
    }
}