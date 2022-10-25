class Solution {
    public int minTotalDistance(int[][] grid) {
        double cnt = 0;
        double dr = 0;
        double dc = 0;
        List<int[]> friends = new ArrayList();
        for (int r=0; r<grid.length; r++) {
            for (int c=0; c<grid[r].length; c++) {
                if (grid[r][c] == 1) {
                    friends.add(new int[]{r,c});
                    dr += r;
                    dc += c;
                    cnt += 1;
                }
            }
        }
        
        List<int[]> candidates = new ArrayList();
        // System.out.println(String.format("dr: %f, dc: %f, cnt: %f", dr, dc, cnt));
        dr /= cnt;
        dc /= cnt;
        if (dr % 1 == 0) {
            if (dc % 1 == 0) {
                candidates.add(new int[]{(int)dr, (int)dc});
            }
            else {
                candidates.add(new int[]{(int)dr, (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)dr, (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)dr, (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)dr, (int)Math.floor(dc)});
                candidates.add(new int[]{(int)dr, (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)dr, (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)dr, (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)dr, (int)Math.ceil(dc)+3});
            }
        }
        else {
            if (dc % 1 == 0) {
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)dc});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)dc});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)dc});
                candidates.add(new int[]{(int)Math.floor(dr), (int)dc});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)dc});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)dc});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)dc});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)dc});
            }
            else {
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)Math.floor(dc)});
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)Math.floor(dr)-3, (int)Math.ceil(dc)+3});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)Math.floor(dc)});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)Math.floor(dr)-2, (int)Math.ceil(dc)+3});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)Math.floor(dc)});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)Math.floor(dr)-1, (int)Math.ceil(dc)+3});
                candidates.add(new int[]{(int)Math.floor(dr), (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)Math.floor(dr), (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)Math.floor(dr), (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)Math.floor(dr), (int)Math.floor(dc)});
                candidates.add(new int[]{(int)Math.floor(dr), (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)Math.floor(dr), (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)Math.floor(dr), (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)Math.floor(dr), (int)Math.ceil(dc)+3});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)Math.floor(dc)});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)Math.ceil(dr), (int)Math.ceil(dc)+3});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)Math.floor(dc)});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)Math.ceil(dr)+1, (int)Math.ceil(dc)+3});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)Math.floor(dc)});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)Math.ceil(dr)+2, (int)Math.ceil(dc)+3});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)Math.floor(dc)-3});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)Math.floor(dc)-2});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)Math.floor(dc)-1});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)Math.floor(dc)});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)Math.ceil(dc)});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)Math.ceil(dc)+1});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)Math.ceil(dc)+2});
                candidates.add(new int[]{(int)Math.ceil(dr)+3, (int)Math.ceil(dc)+3});
            }
        }
        
        int min = Integer.MAX_VALUE;
        for (int[] c : candidates) {
            // System.out.println(Arrays.toString(c));
            int local = 0;
            for (int[] f : friends) {
                local += Math.abs(f[0]-c[0]) + Math.abs(f[1]-c[1]);
            }
            min = Math.min(min, local);
        }
        return min;
    }
}

/*

[[0,1],[0,1],[0,1],[1,1],[0,0],[0,1],[0,0],[0,0],[0,0],[0,0],[1,0],[1,0],[0,0],[0,0],[1,1],[0,0]]


[
[0,1],
[0,1],
[0,1],
[1,1],
[0,0],
[0,1],
[0,0],
[0,0],
[0,0],
[0,0],
[1,0],
[1,0],
[0,0],
[0,0],
[1,1],
[0,0]
]

[[1,1,0,0,0,1],[0,0,1,0,0,0],[0,1,1,0,0,0],[0,0,1,0,1,0],[0,0,0,0,0,0],[0,0,0,0,0,0],[0,0,0,0,0,1],[0,1,0,0,0,0],[0,1,0,0,0,0],[0,0,0,0,1,0],[0,0,0,0,0,0],[1,1,1,1,1,1],[0,1,0,0,1,1],[0,0,0,1,1,0],[0,1,0,0,0,0],[1,1,1,1,0,1],[0,0,0,0,0,0]]
*/