class Graph {
    int n;
    Map<Integer, Map<Integer, Integer>> adj;
    int[][] d;
    
    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new HashMap();
        d = new int[n][n];
        for (int[] e : edges) {
            int from = e[0];
            int to = e[1];
            int dist = e[2];
            adj.putIfAbsent(from, new HashMap());
            adj.get(from).put(to, dist);
        }
        floydWarshall();
    }
    
    public void addEdge(int[] edge) {
        int from = edge[0];
        int to = edge[1];
        int dist = edge[2];
        adj.putIfAbsent(from, new HashMap());
        adj.get(from).put(to, dist);
        floydWarshall();
    }
    
    public void floydWarshall() {
        for (int from=0; from<n; from++) {
            if (!adj.containsKey(from)) {
                Arrays.fill(d[from], Integer.MAX_VALUE/4);
                continue;
            }
            for (int to=0; to<n; to++) {
                if (!adj.get(from).containsKey(to)) {
                    d[from][to] = Integer.MAX_VALUE/4;
                }
                else {
                    d[from][to] = adj.get(from).get(to);
                }
            }
        }
        for (int from=0; from<n; from++) {
            d[from][from] = 0;
        }
        
        // System.out.println("after init:");
        // for (int from=0; from<n; from++) {
        //     System.out.println(Arrays.toString(d[from]));
        // }
        
        for (int mid=0; mid<n; mid++) {
            for (int from=0; from<n; from++) {
                for (int to=0; to<n; to++) {
                    d[from][to] = Math.min(d[from][to], d[from][mid]+d[mid][to]);
                }
            }
        }
        
        // System.out.println("after calc:");
        // for (int from=0; from<n; from++) {
        //     System.out.println(Arrays.toString(d[from]));
        // }
        // System.out.println("done.");
    }
    
    public int shortestPath(int node1, int node2) {
        return d[node1][node2] == Integer.MAX_VALUE/4 ? -1 : d[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */

/*
["Graph","addEdge","addEdge","addEdge","addEdge","addEdge","shortestPath","shortestPath","shortestPath","addEdge","addEdge","addEdge","shortestPath","addEdge","addEdge","shortestPath","shortestPath","shortestPath","addEdge","addEdge","shortestPath","shortestPath","shortestPath","shortestPath","addEdge","addEdge","shortestPath","shortestPath","shortestPath","shortestPath","shortestPath","addEdge","shortestPath","addEdge","shortestPath","shortestPath","shortestPath","addEdge","shortestPath","shortestPath","shortestPath","shortestPath","shortestPath","addEdge","shortestPath","shortestPath","shortestPath"]
[
[13,[[11,6,84715],[7,9,764823],[6,0,315591],[1,4,909432],[6,5,514907],[9,6,105610],[3,10,471042],[7,10,348752],[5,11,715628],[6,1,973999],[8,7,593929],[7,6,64688],[6,4,741734],[10,1,894247],[9,7,81181],[2,11,75418],[12,2,85431],[7,2,260306],[11,9,640614],[2,3,648804],[4,12,568023],[0,8,730096],[9,11,633474],[3,6,390214],[1,10,117955],[9,8,222602],[10,7,689294]]],
[[1,2,36450]],
[[8,0,709628]],
[[2,4,30185]],
[[12,1,21696]],
[[1,8,2553]],
[8,9],
[1,11],
[3,4],
[[4,6,2182]],
[[7,5,206]],
[[5,7,140]],
[12,5],
[[12,6,365184]],
[[3,2,5]],
[4,8],
[7,10],
[0,5],
[[0,11,5]],
[[1,7,5]],
[0,8],
[11,11],[7,4],[0,12],[[3,9,858944]],[[0,9,4]],[3,5],[4,5],[12,9],[9,8],[3,5],[[12,9,629052]],[3,8],[[4,0,545201]],[11,8],[4,11],[9,6],[[12,7,4]],[7,10],[2,5],[6,11],[12,2],[9,7],[[4,3,879736]],[1,3],[1,0],[4,6]]
*/