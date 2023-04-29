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
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, (a, b) -> a[2]-b[2]);
        int[][] newQueries = new int[queries.length][4];
        for (int i=0; i<queries.length; i++) {
            newQueries[i] = new int[]{queries[i][0], queries[i][1], queries[i][2], i};
        }
        Arrays.sort(newQueries, (a, b) -> a[2]-b[2]);
        UnionFind uf = new UnionFind(n);
        int edgeListIndex = 0;
        boolean[] result = new boolean[queries.length];
        for (int[] query : newQueries) {
            while (edgeListIndex < edgeList.length
                   && edgeList[edgeListIndex][2] < query[2]) {
                uf.union(edgeList[edgeListIndex][0], edgeList[edgeListIndex][1]);
                edgeListIndex++;
            }
            if (uf.find(query[0]) == uf.find(query[1])) {
                result[query[3]] = true;
            }
            else {
                result[query[3]] = false;
            }
        }
        return result;
    }
}