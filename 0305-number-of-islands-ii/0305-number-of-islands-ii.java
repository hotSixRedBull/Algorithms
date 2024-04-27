class UnionFind {
    int[] parent;
    int[] rank;
    int m;
    int n;
    Set<Integer> ps;
    
    public UnionFind(int m, int n) {
        this.m = m;
        this.n = n;
        parent = new int[m*n];
        rank = new int[m*n];
        Arrays.fill(rank, 0);
        Arrays.fill(parent, -1);
        ps = new HashSet();
    }
    
    public void add(int a) {
        parent[a] = a;
        ps.add(a);
    }
    
    public int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        int cur = a;
        while (parent[cur] != cur) {
            cur = parent[cur];
            parent[a] = parent[cur];
        }
        return parent[a];
    }
    
    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        if (rank[pa] <= rank[pb]) {
            rank[pa]++;
            parent[parent[b]] = pa;
            ps.remove(pb);
        }
        else {
            rank[pb]++;
            parent[parent[a]] = pb;
            ps.remove(pa);
        }
        return true;
    }
    
    public int hash(int r, int c) {
        return r*n+c;
    }
    
    public int[] unhash(int a) {
        return new int[]{(int)Math.floor(a/n), a%n};
    }
    
    public int getIslands() {
        return ps.size();
    }
}

class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[][] grid = new int[m][n];
        UnionFind uf = new UnionFind(m, n);
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};
        
        List<Integer> result = new ArrayList();
        for (int[] p : positions) {
            grid[p[0]][p[1]] = 1;
            int key = uf.hash(p[0], p[1]);
            uf.add(key);
            for (int i=0; i<4; i++) {
                int nr = p[0] + dr[i];
                int nc = p[1] + dc[i];
                if (nr < 0
                   || nc < 0
                   || nr >= m
                   || nc >= n
                   || grid[nr][nc] != 1) {
                    continue;
                }
                int neighborKey = uf.hash(nr, nc);
                uf.union(key, neighborKey);
            }
            result.add(uf.getIslands());
        }
        
        return result;
    }
}