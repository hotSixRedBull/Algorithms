class UnionFind {
    int[] group;
    public UnionFind(int s) {
        group = new int[s];
        for (int i=0; i<s; i++) {
            group[i] = i;
        }
    }
    public boolean union(int i, int j) {
        int newI = find(i);
        int newJ = find(j);
        if (newI == newJ) {
            return false;
        }
        group[newI] = newI;
        group[newJ] = newI;
        // System.out.println("group: "+Arrays.toString(group));
        return true;
    }
    public int find(int i) {
        if (group[i] == i) {
            return i;
        }
        return group[i] = find(group[i]);
    }
}

class Edge {
    int from;
    int to;
    int dist;
    public Edge(int f, int t, int d) {
        from = f;
        to = t;
        dist = d;
    }
    public int compare(Edge arg0, Edge arg1) {
        return arg0.dist-arg1.dist;
    }
}

class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> pq = new PriorityQueue(new Comparator<Edge>() {
            @Override
            public int compare(Edge arg0, Edge arg1) {
                return arg0.dist-arg1.dist;
            }
        });
        for (int i=0; i<points.length; i++) {
            for (int j=i+1; j<points.length; j++) {
                pq.add(new Edge(i, j, Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1])));
            }
        }
        UnionFind unionFind = new UnionFind(points.length);
        int sum = 0;
        while (pq.size() > 0) {
            Edge cur = pq.poll();
            if (unionFind.union(cur.from, cur.to)) {
                sum += cur.dist;
                // System.out.println(String.format("cur: %d,%d, sum=%d",cur.from, cur.to, sum));
            }
        }
        return sum;
    }
}