class UnionFind {
    int[] p;
    int[] rank;
    public int units;
    public UnionFind(int siz) {
        p =  new int[siz];
        rank = new int[siz];
        units = siz;
        for (int i=0; i<siz; i++) {
            p[i] = i;
        }
    }
    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return;
        }
        units--;
        if (rank[pa] < rank[pb]) {
            p[pb] = pa;
            rank[pa]++;
        }
        else {
            p[pa] = pb;
            rank[pb]++;
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
        p[a] = cur;
        return cur;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int remainder = 0;
        for (int[] conn : connections) {
            int a = conn[0];
            int b = conn[1];
            if (uf.find(a) == uf.find(b)) {
                remainder++;
            }
            else {
                uf.union(a, b);
            }
        }
        // System.out.println(String.format("units: %d, remainder: %d", uf.units, remainder));
        if (uf.units-1 <= remainder) {
            return uf.units-1;
        }
        else {
            return -1;
        }
    }
}

/*
11
[[1,4],[0,3],[1,3],[3,7],[2,7],[0,1],[2,4],[3,6],[5,6],[6,7],[4,7],[0,7],[5,7]]

[1,4,3,0,7,2,6,5] +6
[7,8,9,10]
*/