class UnionFind {
    int[] p;
    int[] rank;
    public UnionFind(int size) {
        p = new int[size];
        rank = new int[size];
        for (int i=0; i<size; i++) {
            p[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int a) {
        if (p[a] == a) {
            return a;
        }
        int cur = a;
        while (p[cur] != cur) {
            p[cur] = p[p[cur]];
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
        if (rank[pa] < rank[pb]) {
            p[pb] = pa;
            rank[pa] += rank[pb];
        }
        else {
            p[pa] = pb;
            rank[pb] += rank[pa];
        }
    }
}

class Solution {
    public long countPairs(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        long answer = 0;
        // System.out.println(Arrays.toString(uf.rank));
        Set<Integer> visited = new HashSet();
        for (int p : uf.p) {
            int pp = uf.find(p);
            if (visited.contains(pp)) {
                continue;
            }
            visited.add(pp);
            answer += ((long)n-(long)uf.rank[pp])*(long)uf.rank[pp];
        }
        return answer/2;
    }
}

/*
1. think about duplication
2. think about the size of the answer
3. think about time complexity of find
*/