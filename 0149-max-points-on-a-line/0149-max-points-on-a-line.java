class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        Map<Double, Map<Double, Set<Integer>>> lines = new HashMap();
        Map<Double, Set<Integer>> verticalLines = new HashMap();
        int n = points.length;
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                double a = 0;
                double b = 0;
                if (points[i][0] == points[j][0]) {
                    b = (double) points[i][0];
                    if (verticalLines.containsKey(b) == false) {
                        verticalLines.put(b, new HashSet());
                    }
                    verticalLines.get(b).add(i);
                    verticalLines.get(b).add(j);
                    max = Math.max(max, verticalLines.get(b).size());
                    continue;
                }
                else if (points[i][0] < points[j][0]) {
                    a = (double)(points[j][1]-points[i][1]) / (double)(points[j][0]-points[i][0]);
                }
                else {
                    a = (double)(points[i][1]-points[j][1]) / (double)(points[i][0]-points[j][0]);
                }
                b = (double)points[i][1] - (double)(a*points[i][0]);
                if (lines.containsKey(a) == false) {
                    lines.put(a, new HashMap());
                }
                if (lines.get(a).containsKey(b) == false) {
                    lines.get(a).put(b, new HashSet());
                }
                lines.get(a).get(b).add(j);
                lines.get(a).get(b).add(i);
                max = Math.max(max, lines.get(a).get(b).size());
            }
        }
        
        return max;
    }
}

/*
## brute force -> bigger than O(n!)
- align any points in a list
- check those are on a same line
- update result to be returned

# what i need
- data structure that getting closer points with fast performance.
  - If i can do that, i can get points with smallest distance and calculate order.

# line can be defined
- with its gradient and offset.
  y = ax + b, a is gradient and b is offset
  
# exception
- [[3,3],[1,4],[1,1],[2,1],[2,2]]
vertical line has its x coordinate as offset.
- [[0,0],[4,5],[7,8],[8,9],[5,6],[3,4],[1,1]]
variable must be double when calculate gradient
- [[7,3],[19,19],[-16,3],[13,17],[-18,1],[-18,-17],[13,-3],[3,7],[-11,12],[7,19],[19,-12],[20,-18],[-16,-15],[-10,-15],[-16,-18],[-14,-1],[18,10],[-13,8],[7,-5],[-4,-9],[-11,2],[-9,-9],[-5,-16],[10,14],[-3,4],[1,-20],[2,16],[0,14],[-14,5],[15,-11],[3,11],[11,-10],[-1,-7],[16,7],[1,-11],[-8,-3],[1,-6],[19,7],[3,6],[-1,-2],[7,-3],[-6,-8],[7,1],[-15,12],[-17,9],[19,-9],[1,0],[9,-10],[6,20],[-12,-4],[-16,-17],[14,3],[0,-1],[-18,9],[-15,15],[-3,-15],[-5,20],[15,-14],[9,-17],[10,-14],[-7,-11],[14,9],[1,-1],[15,12],[-5,-1],[-17,-5],[15,-2],[-12,11],[19,-18],[8,7],[-5,-3],[-17,-1],[-18,13],[15,-3],[4,18],[-14,-15],[15,8],[-18,-12],[-15,19],[-9,16],[-9,14],[-12,-14],[-2,-20],[-3,-13],[10,-7],[-2,-10],[9,10],[-1,7],[-17,-6],[-15,20],[5,-17],[6,-6],[-11,-8]]
b can be double, too.
*/