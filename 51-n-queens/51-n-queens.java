class Solution {
    static List<List<String>> answers;
    public List<List<String>> solveNQueens(int n) {
        answers = new ArrayList();
        backtrack(new ArrayList(), new ArrayList(), 0, n);
        return answers;
    }
    public void backtrack(List<String> built, List<Integer> pos, int r, int n) {
        if (r == n) {
            answers.add(new ArrayList(built));
        }
        
        boolean[] visited = new boolean[n];
        char[] newLine = new char[n];
        Arrays.fill(newLine, '.');
        for (int i=0; i<pos.size(); i++) {
            // System.out.println(built.get(i));
            // System.out.println(pos.get(i));
            visited[pos.get(i)] = true;
            int lineDiff = r-i;
            if (pos.get(i) + lineDiff >= 0
               && pos.get(i) + lineDiff < n) {
                visited[pos.get(i)+lineDiff] = true;
            } 
            if (pos.get(i) - lineDiff < n
               && pos.get(i) - lineDiff >= 0) {
                visited[pos.get(i)-lineDiff] = true;
            }
        }
        // System.out.println(Arrays.toString(visited));
        for (int i=0; i<n; i++) {
            if (visited[i] == false) {
                pos.add(i);
                newLine[i] = 'Q';
                built.add(new String(newLine));
                backtrack(built, pos, r+1, n);
                pos.remove(pos.size()-1);
                newLine[i] = '.';
                built.remove(built.size()-1);
            }
        }
    }    
}