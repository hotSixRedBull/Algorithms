class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo=0, hi=matrix.length-1;
        while (lo <= hi) {
            int mid = lo - (lo-hi)/2;
            if (matrix[mid][0] == target) {
                return true;
            }
            else if (matrix[mid][0] < target) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        
        int row = 0;
        if (lo < matrix.length) {
            if (matrix[lo][0] < target) {
                row = lo; 
            }
            else {
                row = Math.max(0, lo-1);
            }
        }
        else {
            row = Math.max(0, lo-1);
        }
        // System.out.println("row: "+row);
        lo=0;
        hi=matrix[row].length-1;
        while (lo <= hi) {
            int mid = lo - (lo-hi)/2;
            // System.out.println("mid: "+mid);
            if (matrix[row][mid] == target) {
                return true;
            }
            else if (matrix[row][mid] < target) {
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        return false;
    }
}

/*
[[1]]
0
[[1]]
1
[[1,3,5,7],[10,11,16,20],[23,30,34,60]]
3
[[1]]
2
[[1,3,5,7],[10,11,16,20],[23,30,34,50]]
30
*/