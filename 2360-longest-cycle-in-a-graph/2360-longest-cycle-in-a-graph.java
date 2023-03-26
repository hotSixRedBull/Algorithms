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
}
class Solution {
    public int longestCycle(int[] edges) {
        int n = edges.length;
        Set<Integer> available = new HashSet();
        int[] incoming = new int[edges.length];
        for (int i=0; i < n; i++) {
            available.add(i);
        }
        for (int i=0; i < n; i++) {
            if (edges[i] == -1) {
                continue;
            }
            incoming[edges[i]]++;
        }
        for (int i=0; i<n; i++) {
            if (available.contains(i) == false) {
                continue;
            }
            if (incoming[i] == 0) {
                Queue<Integer> q = new ArrayDeque();
                q.add(i);
                available.remove(i);
                while (q.size() > 0) {
                    int cur = q.poll();
                    int next = edges[cur];
                    if (next != -1) {
                        incoming[next]--;
                        if (incoming[next] == 0) {
                            available.remove(next);
                            q.add(next);
                        }
                    }
                }
            }
        }
        
        int longest = -1;
        UnionFind uf = new UnionFind(n);
        for (int i=0; i<n; i++) {
            int a = i;
            int b = edges[i];
            if (available.contains(a)
               && available.contains(b)) {
                uf.union(a, b);
            }
        }
        Set<Integer> visited = new HashSet();
        for (int node : uf.p) {
            if (available.contains(node)
               && visited.contains(node) == false) {
                visited.add(node);
                longest = Math.max(longest, uf.r[node]);
            }
        }
        return longest;
    }
}