class UnionFind {
    int[] p;
    int[] r;
    int g;
    public UnionFind(int size) {
        p = new int[size+1];
        r = new int[size+1];
        for (int i=0;i <= size; i++) {
            p[i] = i;
            r[i] = 1;
        }
        g = size;
    }
    public int find(int a) {
        int cur = a;
        while (p[cur] != cur) {
            cur = p[cur];
        }
        return p[a] = cur;
    }
    public boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) {
            return false;
        }
        g--;
        if (r[pa] < r[pb]) {
            p[pb] = p[pa];
        }
        else if (r[pa] > r[pb]) {
            p[pa] = p[pb];
        }
        else if (r[pa] == r[pb]) {
            p[pb] = p[pa];
            r[pa]++;
        }
        return true;
    }
    public int getGroup() {
        return g;
    }
}

class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind ufAlice = new UnionFind(n);
        UnionFind ufBob = new UnionFind(n);
        Arrays.sort(edges, (a, b) -> b[0]-a[0]);
        int need = 0;
        for (int[] edge : edges) {
            boolean doesAliceNeed = false;
            boolean doesBobNeed = false;
            if (edge[0] == 3) {
                doesAliceNeed = ufAlice.union(edge[1], edge[2]);
                doesBobNeed = ufBob.union(edge[1], edge[2]);
            }
            else if (edge[0] == 1) {
                doesAliceNeed = ufAlice.union(edge[1], edge[2]);
            }
            else if (edge[0] == 2) {
                doesBobNeed = ufBob.union(edge[1], edge[2]);
            }
            if (doesAliceNeed || doesBobNeed) {
                need++;
            }
        }
        // System.out.println(String.format("ufAlice.getGroup(): %d, ufBob.getGroup(): %d",
        //                                  ufAlice.getGroup(),
        //                                 ufBob.getGroup()));
        if (ufAlice.getGroup() != 1
           || ufBob.getGroup() != 1) {
            return -1;
        }
        return edges.length - need;
    }
}