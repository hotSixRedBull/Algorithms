class Solution {
    public void rotate(int[][] matrix) {
	int width = matrix[0].length;
	int height = matrix.length;
        for (int r = 0; r<(height+1)/2; r++) {
		for (int c=0; c<width/2; c++) {
			int first = matrix[r][c];
			int second = matrix[c][width-1-r];
			int third = matrix[width-1-r][height-1-c];
			int forth = matrix[height-1-c][r];
			// 0,1 -> 1,3 -> 3,2 -> 2,0
			// 0,2 -> 2,3 -> 3,1 -> 1,0
			// 1,1 -> 1,2 -> 2,2 -> 2,1
			matrix[c][width-1-r]= first;
			matrix[width-1-r][height-1-c] = second;
			matrix[height-1-c][r] = third;
			matrix[r][c] = forth;
}
}
    }
}
