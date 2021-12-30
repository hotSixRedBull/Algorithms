class Solution {
    int[][] image;
    int[][] copyImage;
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        this.image = img;
        this.copyImage = new int[m][n];
        for (int r=0; r<img.length; r++) {
            for (int c=0; c<img[r].length; c++) {
                copyImage[r][c] = img[r][c];
            }
        }
        for (int r=0; r<img.length; r++) {
            for (int c=0; c<img[r].length; c++) {
                roundUp(r, c, m, n);
            }
        }
        return this.image;
    }
    public void roundUp(int row, int col, int m, int n) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(this.copyImage[row][col]);
        list.add(row > 0 ? this.copyImage[row-1][col] : -1);
        list.add(row > 0 && col+1 < n ? this.copyImage[row-1][col+1] : -1);
        list.add(col+1 < n ? this.copyImage[row][col+1] : -1);
        list.add(row+1 < m && col+1 < n ? this.copyImage[row+1][col+1] : -1);
        list.add(row+1 < m ? this.copyImage[row+1][col] : -1);
        list.add(row+1 < m && col > 0 ? this.copyImage[row+1][col-1] : -1);
        list.add(col > 0 ? this.copyImage[row][col-1] : -1);
        list.add(row > 0 && col > 0 ? this.copyImage[row-1][col-1] : -1);
        
        int sum = 0;
        int cnt = 0;
        for (int i=0; i<list.size(); i++) {
            int val = list.get(i);
            if (val != -1) {
                cnt++;
                sum += val;
            }
        }
        this.image[row][col] = sum/cnt;
    }
}