class Solution {
    public int totalNQueens(int n) {
        return countNQueens(n, 0, new ArrayList());
    }
    public int countNQueens(int n, int row, List<Integer> pos) {
        if (row == n) {
            return 1;
        }
        
        boolean[] visited = new boolean[n];
        for (int i=0; i<pos.size(); i++) {
            int lineDiff = row-i;
            visited[pos.get(i)] = true;
            if (pos.get(i)+lineDiff < n) {
                visited[pos.get(i)+lineDiff] = true;
            }
            if (pos.get(i)-lineDiff >= 0) {
                visited[pos.get(i)-lineDiff] = true;
            }
        }
        
        int ret = 0;
        for (int i=0; i<n; i++) {
            if (visited[i] == false) {
                pos.add(i);
                ret += countNQueens(n, row+1, pos);
                pos.remove(row);
            }
        }
        return ret;
    }
}