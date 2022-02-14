class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        Arrays.sort(coordinates, new Comparator<int[]>() {
           @Override
            public int compare(int[] arg0, int[] arg1) {
                if (arg0[0] < arg1[0]) {
                    return -1;
                }
                else if (arg0[0] > arg1[0]) {
                    return 1;
                }
                else {
                    if (arg0[1] < arg1[1]) {
                        return -1;
                    }
                    else if (arg0[1] > arg1[1]) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
            }
        });
        double inclination = 0;
        if (coordinates.length > 1) {
            if (coordinates[1][0]-coordinates[0][0] != 0) {
                inclination = (coordinates[1][1]-coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);
            }
            else {
                inclination = 1;
            }
        } 
        for (int i=1; i<coordinates.length; i++) {
            double localInclination = 0;  
            if (coordinates[i][0]-coordinates[i-1][0] != 0) {
                localInclination = (coordinates[i][1]-coordinates[i-1][1])/(coordinates[i][0]-coordinates[i-1][0]);
            }
            else {
                localInclination = 1;
            }
            if (inclination != localInclination) {
                return false;
            }
            // System.out.println(Arrays.toString(coordinate));
        }
        
        return true;
    }
}

/*
[[0,0],[0,1],[0,-1]]
[[1,1],[2,2],[2,0]]
*/