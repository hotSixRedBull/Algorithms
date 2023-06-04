class UnionFind {
    int[] p;
    int[] r;
    public UnionFind(int size) {
        p = new int[size];
        r = new int[size];
        for (int i=0; i<size; i++) {
            p[i] = i;
            r[i] = 1;
        }
    }
    public int find(int a) {
        if (p[a] == a) {
            return a;
        }
        int cur = a;
        while (p[cur] != cur) {
            cur = p[cur];
        }
        return p[a] = cur;
    }
    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }
        if (r[pa] < r[pb]) {
            p[pb] = p[pa];
            r[pa] += r[pb];
        }
        else {
            p[pa] = p[pb];
            r[pb] += r[pa];
        }
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind uf = new UnionFind(n);
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == j) {
                    continue;
                }
                if (isConnected[i][j] == 1) {
                    uf.union(i,j);
                }
            }
        }
        Set<Integer> parents = new HashSet();
        for (int i=0; i<n; i++) {
            parents.add(uf.find(i));
        }
        return parents.size();
    }
}