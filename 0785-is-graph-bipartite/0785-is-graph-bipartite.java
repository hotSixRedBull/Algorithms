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
        return p[a] = find(p[a]);
    }
    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        if (r[pa] < r[pb]) {
            p[pb] = pa;
            r[pa] += r[pb];
        }
        else {
            p[pa] = pb;
            r[pb] += r[pa];
        }
        return true;
    }
    public int getGroups() {
        Set<Integer> set = new HashSet();
        for (int a : p) {
            int pa = find(a);
            set.add(pa);
        }
        return set.size();
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        UnionFind uf = new UnionFind(n);
        for (int i=0; i<n; i++) {
            for (int adj : graph[i]) {
                if (uf.find(i) == uf.find(adj)) {
                    return false;
                }
                for (int adj2 : graph[adj]) {
                    uf.union(i, adj2);
                }
            }
        }
        return true;
    }
}

/*
[[4],[],[4],[4],[0,2,3]]

0 - 4
1
2 - 4
3 - 4
*/