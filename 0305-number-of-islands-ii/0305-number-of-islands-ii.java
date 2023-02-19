class UnionFind {
    int[] p; //parent
    int[] r; //rank
    int size;
    Set<Integer> parents;
    public UnionFind(int siz) {
        p = new int[siz+1];
        r = new int[siz+1];
        size = 1;
        parents = new HashSet();
    }
    public int add() {
        p[size] = size;
        parents.add(size);
        size++;
        return size-1;
    }
    public int find(int num) {
        if (p[num] == num) {
            return num;
        }
        int cur = num;
        while (p[cur] != cur) {
            cur = p[cur];
        }
        return p[num] = cur;
    }
    public void union(int a, int b) {
        // System.out.println(String.format("union(%d, %d)", a, b));
        // System.out.println(String.format("Before union: %s", parents));
        int pa = find(a);
        int pb = find(b);
        if (r[pa] < r[pb]) {
            p[pb] = p[pa];
            parents.remove(pb);
            parents.add(pa);
            r[pa]++;
        }
        else {
            p[pa] = p[pb];
            parents.remove(pa);
            parents.add(pb);
            r[pb]++;
        }
        // System.out.println(String.format("After union: %s", parents));
    }
    public int getIslands() {
        // System.out.println(parents);
        return parents.size();
    }
}

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] coorToNum = new int[m][n];
        UnionFind uf = new UnionFind(positions.length);
        int[] dr = new int[]{-1,0,1,0};
        int[] dc = new int[]{0,1,0,-1};
        List<Integer> result = new ArrayList();
        for (int[] position : positions) {
            int r = position[0];
            int c = position[1];
            if (coorToNum[r][c] != 0) {
                result.add(uf.getIslands());
                continue;
            }
            int index = uf.add();
            coorToNum[r][c] = index;
            for (int i=0; i<4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n || coorToNum[nr][nc] == 0) {
                    continue;
                }
                uf.union(index, coorToNum[nr][nc]);
            }
            result.add(uf.getIslands());
        }
        return result;
    }
}

/*
3
3
[[0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1]]
3
3
[[0,0],[0,1],[1,2],[1,2]]
3
3
[[0,0],[2,0],[0,1],[2,1],[0,2],[2,2],[0,1],[1,2]]
*/