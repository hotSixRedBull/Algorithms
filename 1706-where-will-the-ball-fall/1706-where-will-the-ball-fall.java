class Solution {
    public int[] findBall(int[][] grid) {
        int[] pos = new int[grid[0].length];
        for (int i=0; i<grid[0].length; i++) {
            pos[i] = i;
        }
        for (int r=0; r<grid.length; r++) {
            for (int i=0; i<pos.length; i++) {
                if (pos[i] == -1) {
                    continue;
                }
                pos[i] = getNext(pos[i], grid[r]);
            }
        }
        return pos;
    }
    public int getNext(int pos, int[] map) {
        if ((pos == 0 && map[0] == -1)
           || (pos == map.length-1 && map[pos] == 1)) {
            return -1;
        }
        if (map[pos] == 1) {
            if (map[pos+1] == 1) {
                return pos+1;
            }
        }
        else { // map[pos] == -1
            if (map[pos-1] == -1) {
                return pos-1;
            }
        }
        return -1;
    }
}